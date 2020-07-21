package com.smarttoolfactory.tutorial9_2core.di

import android.app.Application
import android.content.Context
import com.smarttoolfactory.tutorial9_2core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial9_2core.model.CoreCameraDependency
import com.smarttoolfactory.tutorial9_2core.model.CoreDependency
import com.smarttoolfactory.tutorial9_2core.model.CorePhotoDependency
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CoreProvideModule::class])
abstract class CoreModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}

@Module
object CoreProvideModule {

    @Singleton
    @Provides
    fun provideCoreDependency(application: Application) = CoreDependency(application)

    @Provides
    fun provideCoreActivityDependency(context: Context) = CoreActivityDependency(context)

    @Provides
    fun provideCoreCameraDependency(): CoreCameraDependency = CoreCameraDependency()

    @Provides
    fun provideCorePhotoDependency(): CorePhotoDependency = CorePhotoDependency()

}