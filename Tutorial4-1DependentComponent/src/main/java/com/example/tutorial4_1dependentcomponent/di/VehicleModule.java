package com.example.tutorial4_1dependentcomponent.di;

import com.example.tutorial4_1dependentcomponent.model.Motor;
import com.example.tutorial4_1dependentcomponent.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class VehicleModule {
    @Provides
    Vehicle provideVehicle(Motor motor) {
        return new Vehicle(motor);
    }
}
