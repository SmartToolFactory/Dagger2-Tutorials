package com.smarttoolfactory.feature_hilt_camera.di

import android.app.Application
import com.smarttoolfactory.feature_hilt_camera.CameraActivity
import com.smarttoolfactory.feature_hilt_camera.CameraFragment1
import com.smarttoolfactory.feature_hilt_camera.CameraFragment2
import com.smarttoolfactory.tutorial10_1core.di.CoreComponentDependencies
import dagger.BindsInstance
import dagger.Component

@Component(
        dependencies = [CoreComponentDependencies::class],
        modules = [CameraModule::class]
)
interface CameraComponent {

    fun inject(cameraFragment1: CameraFragment1)
    fun inject(cameraFragment2: CameraFragment2)


    fun inject(cameraActivity: CameraActivity)

    @Component.Factory
    interface Factory {
        fun create(coreComponentDependencies: CoreComponentDependencies, @BindsInstance application: Application): CameraComponent
    }

}