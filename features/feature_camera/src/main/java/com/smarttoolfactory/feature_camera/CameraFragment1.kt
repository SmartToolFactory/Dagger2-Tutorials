package com.smarttoolfactory.feature_camera

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.feature_camera.di.CameraModule
import com.smarttoolfactory.feature_camera.di.DaggerCameraComponent
import com.smarttoolfactory.feature_camera.model.CameraObject
import com.smarttoolfactory.tutorial9_2core.di.CoreModule
import com.smarttoolfactory.tutorial9_2core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial9_2core.model.CoreCameraDependency
import com.smarttoolfactory.tutorial9_2core.model.CoreDependency
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.coreComponent
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
                        "CoreModule @ActivityScope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                        "CoreModule no scope coreCameraDependency: ${coreCameraDependency.hashCode()}\n" +
                        "CameraModule  @FeatureScope cameraObject: ${cameraObject.hashCode()}"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initCoreDependentInjection()
        super.onCreate(savedInstanceState)
    }

    private fun initCoreDependentInjection() {

        DaggerCameraComponent.factory()
                .create(coreComponent = requireActivity().coreComponent(),
                        cameraModule = CameraModule(),
                        application = requireActivity().application)
                .inject(this)
    }
}