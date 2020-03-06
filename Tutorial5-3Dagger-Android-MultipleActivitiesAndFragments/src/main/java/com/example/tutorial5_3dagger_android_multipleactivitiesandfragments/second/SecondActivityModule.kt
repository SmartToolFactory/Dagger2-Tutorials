package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.second

import android.content.Context
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.scope.ActivityScope
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.ToastMaker
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SecondActivityModule {
    /*
    NOTE: This can only be SecondActivity(AndroidInjector<T>), Activity does not work
     */
    @Binds
    abstract fun bindContext(activity: SecondActivity): Context

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