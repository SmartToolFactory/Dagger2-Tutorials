package com.example.tutorial1daggerbasics2.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/example/tutorial1daggerbasics2/di/VehicleComponent;", "", "provideVehicle", "Lcom/example/tutorial1daggerbasics2/model/Vehicle;", "Tutorial1-3ProvisionMethod_debug"})
@dagger.Component(modules = {com.example.tutorial1daggerbasics2.di.VehicleModule.class})
@javax.inject.Singleton()
public abstract interface VehicleComponent {
    
    /**
     * This method either needs a method with @Provides that returns Vehicle
     * or constructor injection
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.tutorial1daggerbasics2.model.Vehicle provideVehicle();
}