package com.example.tutorial4_3componentbuilders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/example/tutorial4_3componentbuilders/MyApplication;", "Landroid/app/Application;", "()V", "<set-?>", "Lcom/example/tutorial4_3componentbuilders/di/AppComponent;", "appComponent", "getAppComponent", "()Lcom/example/tutorial4_3componentbuilders/di/AppComponent;", "Lcom/example/tutorial4_3componentbuilders/di/AppComponentWithBindsInstance;", "appComponentWithBindsInstance", "getAppComponentWithBindsInstance", "()Lcom/example/tutorial4_3componentbuilders/di/AppComponentWithBindsInstance;", "onCreate", "", "Tutorial4-3ComponentBuilders_debug"})
public final class MyApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private com.example.tutorial4_3componentbuilders.di.AppComponent appComponent;
    @org.jetbrains.annotations.NotNull()
    private com.example.tutorial4_3componentbuilders.di.AppComponentWithBindsInstance appComponentWithBindsInstance;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tutorial4_3componentbuilders.di.AppComponent getAppComponent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tutorial4_3componentbuilders.di.AppComponentWithBindsInstance getAppComponentWithBindsInstance() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public MyApplication() {
        super();
    }
}