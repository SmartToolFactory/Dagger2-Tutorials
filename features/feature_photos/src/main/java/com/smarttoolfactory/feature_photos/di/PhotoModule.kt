package com.smarttoolfactory.feature_photos.di

import android.app.Application
import android.content.Context
import com.smarttoolfactory.feature_photos.model.PhotoObject
import com.smarttoolfactory.tutorial9_2core.di.scope.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [PhotoBindModule::class])
class PhotoModule {

    @FeatureScope
    @Provides
    fun providePhotoObject(application: Application): PhotoObject = PhotoObject(application)

}

@Module
abstract class PhotoBindModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}
