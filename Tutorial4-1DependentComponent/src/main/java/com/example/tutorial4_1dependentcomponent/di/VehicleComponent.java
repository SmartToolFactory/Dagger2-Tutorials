package com.example.tutorial4_1dependentcomponent.di;

import com.example.tutorial4_1dependentcomponent.MainActivity;
import com.example.tutorial4_1dependentcomponent.model.Vehicle;

import javax.inject.Singleton;

import dagger.Component;
@Component(dependencies = {MotorComponent.class}, modules = {VehicleModule.class})
public interface VehicleComponent {
    void inject(MainActivity mainActivity);
}
