package com.example.tutorial5_2dagger_android_subcomponents2.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.tutorial5_2dagger_android_subcomponents2.MainActivity
import com.example.tutorial5_2dagger_android_subcomponents2.SecondActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module(subcomponents = [ToastMakerSubComponent::class, LiveObjectSubComponent::class])
abstract class ApplicationModule {

    /*
    *  NOTE: This is same as adding void inject(MainActivity mainActivity) to SubComponent as in
    *  non dagger-android, and can be removed using
    *  @ContributesAndroidInjector if SubComponent and it's Builder has NO methods
    *
    * !! In kotlin Generic should match with @ClassKey, if it's ? then Kotlin should be *
    */
// 🔥 Injects ToastMakerSubComponent objects to MainActivity
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindMainActivityFactory(builder: ToastMakerSubComponent.Builder): AndroidInjector.Factory<*>

    // 🔥 Injects LiveObjectSubComponent objects to SecondActivity
    @Binds
    @IntoMap
    @ClassKey(SecondActivity::class)
    abstract fun bindSecondActivityFactory(builder: LiveObjectSubComponent.Builder): AndroidInjector.Factory<*>

    companion object {

        @Provides
        @Singleton
        fun provideSharedPreferences(application: Application): SharedPreferences {
            println("ApplicationModule context: $application")
            return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
        }
    }
}