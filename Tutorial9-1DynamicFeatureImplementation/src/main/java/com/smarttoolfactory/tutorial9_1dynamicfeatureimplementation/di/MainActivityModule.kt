package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di

import android.app.Application
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di.scope.ActivityScope
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.MainActivityDependency
import dagger.Module
import dagger.Provides


@Module
abstract class MainActivityModule {

    companion object {

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideToastMaker(context: Application): MainActivityDependency {
            return MainActivityDependency(context)
        }
    }
}