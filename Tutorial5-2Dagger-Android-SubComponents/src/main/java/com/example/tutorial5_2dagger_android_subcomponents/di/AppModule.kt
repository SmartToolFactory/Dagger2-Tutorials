package com.example.tutorial5_2dagger_android_subcomponents.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.tutorial5_2dagger_android_subcomponents.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module(subcomponents = [ToastMakerSubComponent::class])
abstract class AppModule {
    /*
     *  NOTE: This is same as adding void inject(MainActivity mainActivity) to SubComponent as in
     *  non dagger-android, and can be removed using
     *  @ContributesAndroidInjector if SubComponent and it's Builder has NO methods
     */
// 🔥 Injects ToastMakerSubComponent objects to MainActivity
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindMainActivityFactory(builder: ToastMakerSubComponent.Builder): AndroidInjector.Factory<*>

    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideSharedPreferences(application: Application): SharedPreferences {
            println("ApplicationModule context: $application")
            return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
        }
    }
}