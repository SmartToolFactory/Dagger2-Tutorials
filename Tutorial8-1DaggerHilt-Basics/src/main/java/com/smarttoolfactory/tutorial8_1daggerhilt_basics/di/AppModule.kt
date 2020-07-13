package com.smarttoolfactory.tutorial8_1daggerhilt_basics.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.smarttoolfactory.tutorial8_1daggerhilt_basics.model.ToastMaker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
 class AppModule {

    @Singleton
    @Provides
    fun provideToastMaker(@ApplicationContext context: Context): ToastMaker {
        return ToastMaker(context)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences( application: Application): SharedPreferences {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }
}