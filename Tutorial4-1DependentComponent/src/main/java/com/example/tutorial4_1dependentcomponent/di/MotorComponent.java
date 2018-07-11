package com.example.tutorial4_1dependentcomponent.di;

import com.example.tutorial4_1dependentcomponent.model.Motor;

import javax.inject.Singleton;

import dagger.Component;
@Component(modules = {MotorModule.class})
public interface MotorComponent {
    Motor motor();
}
