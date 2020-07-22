package com.smarttoolfactory.feature_hilt_camera

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.feature_hilt_camera.di.DaggerCameraComponent
import com.smarttoolfactory.feature_hilt_camera.model.CameraObject
import com.smarttoolfactory.tutorial10_1core.di.CoreComponent
import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreCameraDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class CameraActivity : AppCompatActivity() {

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


    override fun onCreate(savedInstanceState: Bundle?) {

//        initHiltDependencyInjection()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        findViewById<TextView>(R.id.tvInfo).text =
                "CoreModule @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
                        "CoreModule @ActivityScope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                        "CoreModule no scope coreCameraDependency: ${coreCameraDependency.hashCode()}\n" +
                        "CameraModule  @FeatureScope cameraObject: ${cameraObject.hashCode()}"
    }

    private fun initHiltDependencyInjection() {

        DaggerCameraComponent.factory().create(
                EntryPointAccessors.fromApplication(
                        applicationContext,
                        CoreComponent::class.java
                ),
                application
        )
                .inject(this)


    }


}