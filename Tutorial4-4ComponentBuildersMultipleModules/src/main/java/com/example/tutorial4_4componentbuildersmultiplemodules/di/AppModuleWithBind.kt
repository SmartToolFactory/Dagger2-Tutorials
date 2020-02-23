package com.example.tutorial4_4componentbuildersmultiplemodules.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModuleWithBind {

    @Provides
    @Singleton
    fun providePreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("data",
                Context.MODE_PRIVATE)
    }

}