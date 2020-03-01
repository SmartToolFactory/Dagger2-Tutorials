package com.example.tutorial4_1dependentcomponent.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/example/tutorial4_1dependentcomponent/di/VehicleModule;", "", "()V", "provideVehicle", "Lcom/example/tutorial4_1dependentcomponent/model/Vehicle;", "motor", "Lcom/example/tutorial4_1dependentcomponent/model/Motor;", "Tutorial4-1DependentComponent_debug"})
@dagger.Module()
public final class VehicleModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.tutorial4_1dependentcomponent.model.Vehicle provideVehicle(@org.jetbrains.annotations.NotNull()
    com.example.tutorial4_1dependentcomponent.model.Motor motor) {
        return null;
    }
    
    public VehicleModule() {
        super();
    }
}