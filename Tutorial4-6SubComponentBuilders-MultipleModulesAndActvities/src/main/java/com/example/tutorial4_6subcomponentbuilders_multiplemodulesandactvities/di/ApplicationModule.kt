package com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ToastAndPreferencesSubComponent::class, DummyDependencySubComponent::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }
}