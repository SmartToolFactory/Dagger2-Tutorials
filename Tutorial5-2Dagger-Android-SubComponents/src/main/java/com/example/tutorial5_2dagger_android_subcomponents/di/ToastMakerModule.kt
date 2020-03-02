package com.example.tutorial5_2dagger_android_subcomponents.di

import android.content.Context
import com.example.tutorial5_2dagger_android_subcomponents.MainActivity
import com.example.tutorial5_2dagger_android_subcomponents.model.ToastMaker
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 *
 *
 * Sub component and @Provides annotated methods inside module CAN NOT not have different scopes.
 *
 *
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes
 */
@Module
abstract class ToastMakerModule {
    /*
    NOTE: This can only be MainActivity(AndroidInjector<T>), Activity does not work
     */
    @Binds
    abstract fun bindContext(mainActivity: MainActivity): Context

    @Module
    companion object {
        @JvmStatic
        @ActivityScope
        @Provides
        fun provideToastMaker(context: Context): ToastMaker {
            return ToastMaker(context)
        }
    }
}