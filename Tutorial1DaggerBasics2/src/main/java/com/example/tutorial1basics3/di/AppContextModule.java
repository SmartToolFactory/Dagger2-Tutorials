package com.example.tutorial1basics3.di;

import com.example.tutorial1basics3.MyApplication;
import com.example.tutorial1basics3.sensors.SensorController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppContextModule {
    private final MyApplication mMyApplication;

    public AppContextModule(MyApplication context) {
        mMyApplication = context;
    }

    @Singleton
    @Provides
    MyApplication provideMyApplication() {
        return mMyApplication;
    }

    @Provides
    SensorController provideSensorController() {
        return new SensorController(mMyApplication);
    }

}
