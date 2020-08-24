package com.smarttoolfactory.feature_hilt_camera

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.feature_hilt_camera.di.DaggerCameraComponent
import com.smarttoolfactory.feature_hilt_camera.model.CameraObject
import com.smarttoolfactory.tutorial10_1core.di.CoreModuleDependencies
import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreCameraDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class CameraFragment1 : Fragment() {

    /**
     * Injected from [CoreModule] with @Singleton scope
     */
    @Inject
    lateinit var coreDependency: CoreDependency

    /**
     * Injected from [CoreModule] with no scope
     */
    @Inject
    lateinit var coreActivityDependency: CoreActivityDependency

    /**
     * Injected from [CoreModule] with no scope
     */
    @Inject
    lateinit var coreCameraDependency: CoreCameraDependency

    /**
     * Injected from [CameraModule] with @FeatureScope
     */
    @Inject
    lateinit var cameraObject: CameraObject

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_camera1, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnNextPage).setOnClickListener {
            findNavController().navigate(R.id.action_cameraFragment1_to_cameraFragment2)
        }

        view.findViewById<TextView>(R.id.tvInfo).text =
                "CoreModule @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
                        "CoreModule no scope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                        "CoreModule no scope coreCameraDependency: ${coreCameraDependency.hashCode()}\n" +
                        "CameraModule  no scope cameraObject: ${cameraObject.hashCode()}"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initCoreDependentInjection()
        super.onCreate(savedInstanceState)
    }

    private fun initCoreDependentInjection() {

        val coreModuleDependencies = EntryPointAccessors.fromApplication(
                requireActivity().applicationContext,
                CoreModuleDependencies::class.java
        )

        DaggerCameraComponent.factory().create(
                coreModuleDependencies,
                requireActivity().application
        )
                .inject(this)

    }
}