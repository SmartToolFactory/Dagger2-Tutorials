package com.smarttoolfactory.feature_hilt_photos.di

import android.app.Application
import com.smarttoolfactory.feature_hilt_photos.PhotoFragment1
import com.smarttoolfactory.feature_hilt_photos.PhotoFragment2
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.di.PhotoModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(
        dependencies = [PhotoModuleDependencies::class],
        modules = [PhotoModule::class]
)
interface PhotoComponent {

    fun inject(photosFragment1: PhotoFragment1)
    fun inject(photosFragment2: PhotoFragment2)
    
    @Component.Factory
    interface Factory {
        fun create(photoModuleDependencies: PhotoModuleDependencies,
                   @BindsInstance application: Application): PhotoComponent
    }
}