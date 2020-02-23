package com.example.tutorial4_3componentbuilders.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This module is created as it's with other examples
 */
@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providePreferences(): SharedPreferences {
        return application.getSharedPreferences("store",
                Context.MODE_PRIVATE)
    }

}