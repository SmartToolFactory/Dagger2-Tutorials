package com.example.tutorial4_1dependentcomponent.di;

import com.example.tutorial4_1dependentcomponent.model.Motor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MotorModule {
    @Provides
    Motor provideMotor() {
        return  new Motor();
    }
}
