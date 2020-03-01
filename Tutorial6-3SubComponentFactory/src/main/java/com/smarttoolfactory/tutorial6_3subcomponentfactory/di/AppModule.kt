package com.smarttoolfactory.tutorial6_3subcomponentfactory.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [DummyDependencySubComponent::class, ToastAndPreferencesSubComponent::class])
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }
}