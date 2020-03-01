package com.example.tutorial1daggerbasics2.di

import com.example.tutorial1daggerbasics2.model.Vehicle
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [VehicleModule::class])
interface VehicleComponent {

    /**
     * This method either needs a method with @Provides that returns Vehicle
     * or constructor injection
     */
    fun provideVehicle(): Vehicle
}