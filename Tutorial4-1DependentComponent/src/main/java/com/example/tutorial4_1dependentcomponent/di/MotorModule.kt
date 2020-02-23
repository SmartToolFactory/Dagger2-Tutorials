package com.example.tutorial4_1dependentcomponent.di

import com.example.tutorial4_1dependentcomponent.model.Motor
import dagger.Module
import dagger.Provides

@Module
class MotorModule {

    @Provides
    fun provideMotor(): Motor {
        return Motor()
    }
}