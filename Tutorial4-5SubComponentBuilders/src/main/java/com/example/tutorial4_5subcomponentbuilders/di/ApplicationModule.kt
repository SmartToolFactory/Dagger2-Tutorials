package com.example.tutorial4_5subcomponentbuilders.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        println("ApplicationModule context: $context")
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }

}