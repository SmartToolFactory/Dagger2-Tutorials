package com.example.tutorial1daggerbasics2.di;

import com.example.tutorial1daggerbasics2.model.Motor;
import com.example.tutorial1daggerbasics2.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class VehicleModule {

    @Singleton
    @Provides
    Motor provideMotor(){
        return new Motor();
    }

    @Singleton
    @Provides
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }
}