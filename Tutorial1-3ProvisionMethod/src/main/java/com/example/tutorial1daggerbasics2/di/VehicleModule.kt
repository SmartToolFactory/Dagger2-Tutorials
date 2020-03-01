package com.example.tutorial1daggerbasics2.di

import com.example.tutorial1daggerbasics2.model.Motor
import com.example.tutorial1daggerbasics2.model.Vehicle
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class VehicleModule {

    @Singleton
    @Provides
    fun provideMotor(): Motor {
        return Motor()
    }

    @Singleton
    @Provides
    fun provideVehicle(): Vehicle {
        return Vehicle(Motor())
    }
}