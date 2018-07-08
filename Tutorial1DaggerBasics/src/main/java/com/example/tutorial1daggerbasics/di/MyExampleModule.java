package com.example.tutorial1daggerbasics.di;


import com.example.tutorial1daggerbasics.model.MyExample;
import com.example.tutorial1daggerbasics.model.MyExampleImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyExampleModule {
    @Singleton
    @Provides
    MyExample provideMyExample() {
        return new MyExampleImpl();
    }
}
