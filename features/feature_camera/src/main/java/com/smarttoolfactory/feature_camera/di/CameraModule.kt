package com.smarttoolfactory.feature_camera.di

import android.app.Application
import android.content.Context
import com.smarttoolfactory.feature_camera.model.CameraObject
import com.smarttoolfactory.tutorial9_2core.di.scope.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [CameraBindModule::class])
class CameraModule {

    @FeatureScope
    @Provides
    fun provideCameraObject(context: Context) = CameraObject(context)
}


@Module
abstract class CameraBindModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}