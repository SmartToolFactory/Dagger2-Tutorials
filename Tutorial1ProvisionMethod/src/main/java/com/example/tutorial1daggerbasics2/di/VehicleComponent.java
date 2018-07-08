package com.example.tutorial1daggerbasics2.di;

import com.example.tutorial1daggerbasics2.model.Motor;
import com.example.tutorial1daggerbasics2.model.Vehicle;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();

}
