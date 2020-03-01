package com.example.tutorial5_1dagger_android.di

import android.app.Application
import android.content.Context
import com.example.tutorial5_1dagger_android.DummyDependency
import com.example.tutorial5_1dagger_android.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivitySubComponent::class])
abstract class AppModule {
    /**
     * Generates an abstract class from a concrete class
     *
     * @param application
     * @return context of application
     */
    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindInjectorFactory(builder: MainActivitySubComponent.Builder)
            : AndroidInjector.Factory<*>

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideDummyDependency(context: Context): DummyDependency {
            return DummyDependency(context)
        }
    }

}

