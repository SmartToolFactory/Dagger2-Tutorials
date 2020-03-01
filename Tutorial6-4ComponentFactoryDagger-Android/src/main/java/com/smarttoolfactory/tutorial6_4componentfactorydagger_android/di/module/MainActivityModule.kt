package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module

import android.content.Context
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.MainActivity
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.scope.ActivityScope
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.model.DummyDependency
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface MainActivityModule {

    companion object {
        // any bindings here are effectvely static and part of the module
        @ActivityScope
        @JvmStatic
        @Provides
        fun provideDummyDependency(context: Context): DummyDependency {
            return DummyDependency(context)
        }
    }

    /*
    NOTE: This can only be MainActivity(AndroidInjector<T>), Activity does not work
     */
    @Binds
    abstract fun bindContext(activity: MainActivity): Context

}
