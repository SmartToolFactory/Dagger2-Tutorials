package com.smarttoolfactory.feature_hilt_photos.di

import android.app.Application
import com.smarttoolfactory.feature_hilt_photos.PhotoActivity
import com.smarttoolfactory.feature_hilt_photos.PhotoFragment1
import com.smarttoolfactory.feature_hilt_photos.PhotoFragment2
import com.smarttoolfactory.tutorial10_1core.di.CoreComponent
import dagger.BindsInstance
import dagger.Component

@Component(
        dependencies = [CoreComponent::class],
        modules = [PhotoModule::class]
)
interface PhotoComponent {

    fun inject(photosFragment1: PhotoFragment1)
    fun inject(photosFragment2: PhotoFragment2)

    fun inject(photoActivity: PhotoActivity)

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent,
                   @BindsInstance application: Application): PhotoComponent
    }
}