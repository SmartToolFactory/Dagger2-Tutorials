package com.example.tutorial5_2dagger_android_subcomponents2.di

import androidx.lifecycle.LifecycleOwner
import com.example.tutorial5_2dagger_android_subcomponents2.model.LiveObject
import dagger.Module
import dagger.Provides

@Module
abstract class LiveObjectModule {

    @Module
    companion object {

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideLiveObject(lifecycleOwner: LifecycleOwner): LiveObject {
            println("LiveObjectModule lifecycleOwner: $lifecycleOwner")
            return LiveObject(lifecycleOwner)
        }

    }


}