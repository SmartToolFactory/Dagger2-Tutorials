package com.example.tutorial4_4componentbuildersmultiplemodules.di;

import android.app.Application;

import com.example.tutorial4_4componentbuildersmultiplemodules.sensors.SensorController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SensorControllerModule {

    @Singleton
    @Provides
    SensorController provideSensorController(Application application) {
        return  new SensorController(application);
    }
}
