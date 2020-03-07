package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main

import android.content.Context
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.scope.ActivityScope
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model.ToastMaker
import dagger.Module
import dagger.Provides

/**
 * Scope of @ContributesAndroidInjector methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 */
@Module
abstract class MainActivityModule {

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