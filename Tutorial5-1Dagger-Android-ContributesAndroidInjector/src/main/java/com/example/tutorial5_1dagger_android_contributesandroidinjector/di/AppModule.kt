package com.example.tutorial5_1dagger_android_contributesandroidinjector.di

import android.app.Application
import android.content.Context
import com.example.tutorial5_1dagger_android_contributesandroidinjector.DummyDependency
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @Module(subcomponents = MainActivitySubComponent.class), MainActivitySubComponent and
 * @Binds
 * @IntoMap
 * @ActivityKey(MainActivity.class)
 * abstract AndroidInjector.Factory
 * bindInjectorFactory(MainActivitySubComponent.Builder builder);
 *
 * is REMOVED when @ContributesAndroidInjector is used with MainActivity
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object {

        @Singleton
        @JvmStatic
        @Provides
        fun provideDummyDependency(context: Context): DummyDependency {
            return DummyDependency(context)
        }
    }
}