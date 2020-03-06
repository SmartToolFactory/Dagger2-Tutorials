package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AppModule of dagger-android with @ContributesAndroidInjector
 * does not declare sub-components inside @Module annotation
 *
 * @Module(subcomponents = {A.class, B.class}) is not used
 */
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