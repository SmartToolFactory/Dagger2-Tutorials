package com.example.tutorial4_1dependentcomponent.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/example/tutorial4_1dependentcomponent/di/MotorComponent;", "", "motor", "Lcom/example/tutorial4_1dependentcomponent/model/Motor;", "Tutorial4-1DependentComponent_debug"})
@dagger.Component(modules = {com.example.tutorial4_1dependentcomponent.di.MotorModule.class})
public abstract interface MotorComponent {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.tutorial4_1dependentcomponent.model.Motor motor();
}