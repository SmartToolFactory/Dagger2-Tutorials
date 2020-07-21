package com.smarttoolfactory.tutorial10_1core.di

import android.app.Application
import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreCameraDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import com.smarttoolfactory.tutorial10_1core.model.CorePhotoDependency
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class CoreModule {

    @Singleton
    @Provides
    fun provideCoreDependency(application: Application) = CoreDependency(application)

    @Provides
    fun provideCoreActivityDependency(context: Application) = CoreActivityDependency(context)

    @Provides
    fun provideCoreCameraDependency(): CoreCameraDependency = CoreCameraDependency()

    @Provides
    fun provideCorePhotoDependency(): CorePhotoDependency = CorePhotoDependency()
}

