package com.example.tutorial3scope2.di

import android.content.Context
import android.content.SharedPreferences
import com.example.tutorial3scope2.model.MySharedPreferences
import com.example.tutorial3scope2.model.SampleObject
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class ApplicationModule(private val context: Context) {

    @ApplicationScope
    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }

    // Field Injection for MySharedPreferences
    @Named("Field")
    @ApplicationScope
    @Provides
    fun provideMySharedPreferences(): MySharedPreferences {
        return MySharedPreferences(context.getSharedPreferences("Constructor", Context.MODE_PRIVATE))
    }

    /**
     * Can provide an object with same scope other objects have or No scope
     */
    @Provides
    fun provideSampleObject(): SampleObject {
        return SampleObject()
    }

}