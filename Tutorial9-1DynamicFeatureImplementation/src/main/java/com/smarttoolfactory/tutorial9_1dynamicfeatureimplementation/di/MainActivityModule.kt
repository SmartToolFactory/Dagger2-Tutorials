package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di

import android.app.Application
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di.scope.ActivityScope
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.ToastMaker
import dagger.Module
import dagger.Provides

/**
 * Scope of @ContributesAndroidInjector methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 */
@Module
abstract class MainActivityModule {

    companion object {

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideToastMaker(context: Application): ToastMaker {
            return ToastMaker(context)
        }
    }
}