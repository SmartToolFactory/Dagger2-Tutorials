package com.smarttoolfactory.feature_hilt_photos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.feature_hilt_photos.di.DaggerPhotoComponent
import com.smarttoolfactory.feature_hilt_photos.model.PhotoObject
import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.di.PhotoModuleDependencies
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.MainActivityObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.SensorController
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.ToastMaker
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class PhotoFragment1 : Fragment() {

    /**
     * Injected from [CoreModule] using [PhotoModuleDependencies] in app module
     */
    @Inject
    lateinit var coreDependency: CoreDependency

    /**
     * Injected from [CoreModule] using [PhotoModuleDependencies] in app module
     */
    @Inject
    lateinit var coreActivityDependency: CoreActivityDependency

    /**
     * Injected from [MainActivityModule] with no scope
     */
    @Inject
    lateinit var toastMaker: ToastMaker

    /**
     *
     * Injected from [MainActivityModule] with @ActivityScope
     * * To inject this there should be @Binds that gets Context from an Application
     */
    @Inject
    lateinit var mainActivityObject: MainActivityObject

    /**
     * Injected from [PhotoModule] with @FeatureScope
     */
    @Inject
    lateinit var photoObject: PhotoObject

    /**
     * Injected via constructor injection with no scope
     */
    @Inject
    lateinit var sensorController: SensorController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photos1, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnNextPage).setOnClickListener {
            findNavController().navigate(R.id.action_photosFragment1_to_photosFragment2)
        }

        view.findViewById<Button>(R.id.btnCamera).setOnClickListener {
            findNavController().navigate(
                    R.id.action_photosFragment1_to_nav_graph_camera)
        }



        view.findViewById<TextView>(R.id.tvInfo).text =
                "CoreModule @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
                        "CoreModule no scope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                        "MainActivityModule no scope toastMaker: ${toastMaker.hashCode()}\n" +
                        "MainActivityModule @ActivityScoped mainActivityObject: ${mainActivityObject.hashCode()}\n" +
                        "PhotoModule no scope photoObject: ${photoObject.hashCode()}\n" +
                        "Constructor no scope sensorController: ${sensorController.hashCode()}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initHiltDependencyInjection()
        super.onCreate(savedInstanceState)
    }


    private fun initHiltDependencyInjection() {

        val photoModuleDependencies = EntryPointAccessors.fromActivity(
                requireActivity(),
                PhotoModuleDependencies::class.java
        )

        DaggerPhotoComponent.factory().create(
                photoModuleDependencies,
                requireActivity().application
        )
                .inject(this)

    }


}