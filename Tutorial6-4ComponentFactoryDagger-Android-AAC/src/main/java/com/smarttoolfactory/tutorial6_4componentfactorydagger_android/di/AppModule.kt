package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.DataModule
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataModule::class, ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }

}