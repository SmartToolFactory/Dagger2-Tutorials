package com.example.tutorial4_1dependentcomponent.di

import com.example.tutorial4_1dependentcomponent.MainActivity
import dagger.Component

@Component(dependencies = [MotorComponent::class], modules = [VehicleModule::class])
interface VehicleComponent {

    fun inject(mainActivity: MainActivity)

}