package com.example.tutorial1daggerbasics2.di

import com.example.tutorial1daggerbasics2.model.Vehicle
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [VehicleModule::class])
interface VehicleComponent {

    fun provideVehicle(): Vehicle
}