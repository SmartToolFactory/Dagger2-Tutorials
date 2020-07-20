package com.smarttoolfactory.feature_photos.di

import android.app.Application
import com.smarttoolfactory.feature_photos.PhotoFragment1
import com.smarttoolfactory.feature_photos.PhotoFragment2
import com.smarttoolfactory.tutorial9_2core.di.scope.FeatureScope
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di.MainActivityComponent
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
        dependencies = [MainActivityComponent::class],
        modules = [PhotoModule::class]
)
interface PhotoComponent {

    fun inject(photosFragment1: PhotoFragment1)
    fun inject(photosFragment2: PhotoFragment2)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent,
                   photoModule: PhotoModule,
                   @BindsInstance application: Application): PhotoComponent
    }
}