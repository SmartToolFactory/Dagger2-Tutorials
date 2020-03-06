package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main

import android.content.Context
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.scope.ActivityScope
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.ToastMaker
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Scope of @ContributesAndroidInjector methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 */
@Module
abstract class MainActivityModule {

    @Binds
    abstract fun bindContext(activity: MainActivity): Context

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