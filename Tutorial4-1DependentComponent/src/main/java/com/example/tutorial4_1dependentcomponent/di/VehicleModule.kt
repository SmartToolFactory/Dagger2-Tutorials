package com.example.tutorial4_1dependentcomponent.di

import com.example.tutorial4_1dependentcomponent.model.Motor
import com.example.tutorial4_1dependentcomponent.model.Vehicle
import dagger.Module
import dagger.Provides

@Module
class VehicleModule {

    @Provides
    fun provideVehicle(motor: Motor): Vehicle {
        return Vehicle(motor)
    }

}