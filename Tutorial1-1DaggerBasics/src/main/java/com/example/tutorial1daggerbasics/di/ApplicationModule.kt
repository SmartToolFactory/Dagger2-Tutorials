package com.example.tutorial1daggerbasics.di

import com.example.tutorial1daggerbasics.model.MyExample
import com.example.tutorial1daggerbasics.model.MyExampleImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @Singleton annotation in Application level module creates Singleton objects. Without @Singleton
 * new instance of provided object is returned.
 *
 * If @Provides method has a scope so should Component has the same scope
 */
@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideMyExample(): MyExample {
        return MyExampleImpl()
    }

}