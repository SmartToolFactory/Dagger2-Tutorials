package com.smarttoolfactory.feature_hilt_photos.di

import android.app.Application
import android.content.Context
import com.smarttoolfactory.feature_hilt_photos.model.PhotoObject
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@InstallIn(FragmentComponent::class)
@Module(includes = [PhotoBindModule::class])
class PhotoModule {

    @Provides
    fun providePhotoObject(application: Application): PhotoObject = PhotoObject(application)

}

@InstallIn(FragmentComponent::class)
@Module
abstract class PhotoBindModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}
