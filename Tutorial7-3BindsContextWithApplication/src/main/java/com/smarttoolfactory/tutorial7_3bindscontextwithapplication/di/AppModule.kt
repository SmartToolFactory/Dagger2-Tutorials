package com.smarttoolfactory.tutorial7_3bindscontextwithapplication.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
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

}