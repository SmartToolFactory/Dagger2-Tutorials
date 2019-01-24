package com.example.tutorial1daggerbasics.di;


import com.example.tutorial1daggerbasics.model.MyExample;
import com.example.tutorial1daggerbasics.model.MyExampleImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @Singleton annotation in Application level module creates Singleton objects. Without @Singleton
 * new instance of provided object is returned.
 * <p>
 * If provides has a scope then the component of this module should have too
 */
@Module
public class ApplicationModule {
    @Singleton
    @Provides
    MyExample provideMyExample() {
        return new MyExampleImpl();
    }
}
