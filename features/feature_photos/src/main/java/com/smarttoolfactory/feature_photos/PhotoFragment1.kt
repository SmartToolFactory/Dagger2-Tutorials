package com.smarttoolfactory.feature_photos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.feature_photos.di.DaggerPhotoComponent
import com.smarttoolfactory.feature_photos.di.PhotoModule
import com.smarttoolfactory.feature_photos.model.PhotoObject
import com.smarttoolfactory.tutorial9_2core.di.CoreModule
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.MainActivity
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di.MainActivityComponent
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di.MainActivityModule
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.MainActivityObject
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.SensorController
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.ToastMaker
import javax.inject.Inject

class PhotoFragment1 : Fragment() {


    /**
     * ❌ Cannot inject from [CoreModule] even though [PhotoComponent]
     * depends on [MainActivityComponent]
     */
//    @Inject
//    lateinit var coreDependency: CoreDependency

    /**
     * ❌ Cannot inject from [CoreModule] even though [PhotoComponent]
     * depends on [MainActivityComponent]
     */
//    @Inject
//    lateinit var coreActivityDependency: CoreActivityDependency

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
//                "CoreModule @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
//                        "CoreModule no scope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                "MainActivityModule no scope toastMaker: ${toastMaker.hashCode()}\n" +
                        "MainActivityModule @ActivityScope mainActivityObject: ${mainActivityObject.hashCode()}\n" +
                        "PhotoModule @FeatureScope photoObject: ${photoObject.hashCode()}\n" +
                        "Constructor no scope sensorController: ${sensorController.hashCode()}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initMainActivityDependentInjection()
        super.onCreate(savedInstanceState)
    }


    private fun initMainActivityDependentInjection() {

        val mainActivity = requireActivity() as MainActivity

        DaggerPhotoComponent.factory()
                .create(mainActivityComponent = mainActivity.mainActivityComponent,
                        photoModule = PhotoModule(),
                        application = mainActivity.application)
                .inject(this)

    }


}