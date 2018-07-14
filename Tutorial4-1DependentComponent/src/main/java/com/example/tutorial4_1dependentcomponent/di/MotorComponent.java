package com.example.tutorial4_1dependentcomponent.di;

import com.example.tutorial4_1dependentcomponent.model.Motor;

import javax.inject.Singleton;

import dagger.Component;
@Component(modules = {MotorModule.class})
public interface MotorComponent {

    // remove injection methods if downstream modules will perform injection

    // downstream components need these exposed
    Motor motor();
}
