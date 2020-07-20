package com.smarttoolfactory.feature_camera.di

import android.app.Application
import com.smarttoolfactory.feature_camera.CameraFragment1
import com.smarttoolfactory.feature_camera.CameraFragment2
import com.smarttoolfactory.tutorial9_2core.di.CoreComponent
import com.smarttoolfactory.tutorial9_2core.di.scope.FeatureScope
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
        dependencies = [CoreComponent::class],
        modules = [CameraModule::class]
)
interface CameraComponent {

    fun inject(cameraFragment1: CameraFragment1)
    fun inject(cameraFragment2: CameraFragment2)

    @Component.Factory
    interface Factory {

        fun create(coreComponent: CoreComponent,
                   cameraModule: CameraModule,
                   @BindsInstance application: Application): CameraComponent

    }

}