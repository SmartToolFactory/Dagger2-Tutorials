package com.example.tutorial4_3componentbuilders.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/tutorial4_3componentbuilders/di/AppComponent;", "", "inject", "", "mainActivity", "Lcom/example/tutorial4_3componentbuilders/MainActivity;", "Builder", "Tutorial4-3ComponentBuilders_debug"})
@dagger.Component(modules = {com.example.tutorial4_3componentbuilders.di.AppModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.tutorial4_3componentbuilders.MainActivity mainActivity);
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/tutorial4_3componentbuilders/di/AppComponent$Builder;", "", "appModule", "Lcom/example/tutorial4_3componentbuilders/di/AppModule;", "build", "Lcom/example/tutorial4_3componentbuilders/di/AppComponent;", "Tutorial4-3ComponentBuilders_debug"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.example.tutorial4_3componentbuilders.di.AppComponent build();
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.example.tutorial4_3componentbuilders.di.AppComponent.Builder appModule(@org.jetbrains.annotations.NotNull()
        com.example.tutorial4_3componentbuilders.di.AppModule appModule);
    }
}