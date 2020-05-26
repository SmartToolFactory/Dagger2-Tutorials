package com.test.tutorial4_7layerlibrary.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.test.tutorial4_7layerlibrary.model.ToastMaker
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseAppModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences =
            application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideToastMaker(application: Application) = ToastMaker(application)
}