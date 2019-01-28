package com.test.tutorial4_8layerlibrary.di;


import com.test.tutorial4_8layerlibrary.model.DummyModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseAppModule {

    @Singleton
    @Provides
    static DummyModel providesDummyModel() {
        return new DummyModel();
    }

}
