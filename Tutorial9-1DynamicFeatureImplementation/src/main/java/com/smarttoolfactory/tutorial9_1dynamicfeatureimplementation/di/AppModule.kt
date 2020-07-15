package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.AnyDependency
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppProviderModule::class])
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context
}

@Module
object AppProviderModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideAnyDependency() = AnyDependency()

}