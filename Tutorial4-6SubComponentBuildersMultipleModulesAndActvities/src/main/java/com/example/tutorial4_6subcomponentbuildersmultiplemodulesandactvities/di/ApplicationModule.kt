package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ToastAndPreferencesSubComponent::class, DummyDependencyComponent::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }
}