package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.AnyDependency
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module()
 class AppModule {

//    @Binds
//    abstract fun bindContext(application: Application): Context

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideAnyDependency() = AnyDependency()
}

/**
 * 🔥🔥 Dependencies provided from object are both Singleton whether they are annotated
 * with @Singleton or not
 */
//@Module
//object AppProviderModule {
//
//    @Provides
//    @Singleton
//    fun provideSharedPreferences(application: Application): SharedPreferences {
//        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
//    }
//
//    @Provides
//    fun provideAnyDependency() = AnyDependency()
//
//}