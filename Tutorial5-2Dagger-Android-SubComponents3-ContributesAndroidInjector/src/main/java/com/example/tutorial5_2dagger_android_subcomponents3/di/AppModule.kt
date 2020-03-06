package com.example.tutorial5_2dagger_android_subcomponents3.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        println("ApplicationModule context: $application")
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }

}