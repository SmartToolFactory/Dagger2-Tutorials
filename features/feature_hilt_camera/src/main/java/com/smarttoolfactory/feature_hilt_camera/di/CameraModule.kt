package com.smarttoolfactory.feature_hilt_camera.di

import android.app.Application
import android.content.Context
import com.smarttoolfactory.feature_hilt_camera.model.CameraObject
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@InstallIn(FragmentComponent::class)
@Module(includes = [CameraBindModule::class])
class CameraModule {

    @Provides
    fun provideCameraObject(context: Context) = CameraObject(context)
}

@InstallIn(FragmentComponent::class)
@Module
abstract class CameraBindModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}