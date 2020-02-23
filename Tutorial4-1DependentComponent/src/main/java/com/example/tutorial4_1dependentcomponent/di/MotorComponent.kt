package com.example.tutorial4_1dependentcomponent.di

import com.example.tutorial4_1dependentcomponent.model.Motor
import dagger.Component

@Component(modules = [MotorModule::class])
interface MotorComponent {

    // remove injection methods if downstream modules will perform injection
    // downstream components need these exposed
    fun motor(): Motor
}
