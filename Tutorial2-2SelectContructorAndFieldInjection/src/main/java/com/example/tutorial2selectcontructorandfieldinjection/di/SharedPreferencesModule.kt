package com.example.tutorial2selectcontructorandfieldinjection.di

import android.content.Context
import android.content.SharedPreferences
import com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class SharedPreferencesModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }

    // Field Injection for MySharedPreferences
    @Named("Field")
    @Singleton
    @Provides
    fun provideMySharedPreferences(): MySharedPreferences {
        return MySharedPreferences(context.getSharedPreferences("Constructor", Context.MODE_PRIVATE))
    }

}