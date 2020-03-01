package com.example.tutorial1daggerbasics2.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/example/tutorial1daggerbasics2/di/VehicleModule;", "", "()V", "provideMotor", "Lcom/example/tutorial1daggerbasics2/model/Motor;", "provideVehicle", "Lcom/example/tutorial1daggerbasics2/model/Vehicle;", "Tutorial1-3ProvisionMethod_debug"})
@dagger.Module()
public final class VehicleModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.tutorial1daggerbasics2.model.Motor provideMotor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.tutorial1daggerbasics2.model.Vehicle provideVehicle() {
        return null;
    }
    
    public VehicleModule() {
        super();
    }
}