package com.example.tutorial5_2dagger_android_subcomponents3.di

import android.content.Context
import com.example.tutorial5_2dagger_android_subcomponents2.model.ToastMaker
import com.example.tutorial5_2dagger_android_subcomponents3.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Scope of @ContributesAndroidInjector methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 */
@Module
abstract class MainActivityModule {
    /*
    NOTE: This can only be MainActivity(AndroidInjector<T>), Activity does not work
     */
    @Binds
    abstract fun bindContext(activity: MainActivity): Context

    companion object {
        @ActivityScope
        @Provides
        fun provideToastMaker(context: Context): ToastMaker {
            return ToastMaker(context)
        }
    }
}