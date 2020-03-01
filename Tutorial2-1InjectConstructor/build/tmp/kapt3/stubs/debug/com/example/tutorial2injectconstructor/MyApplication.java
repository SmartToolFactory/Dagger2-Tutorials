package com.example.tutorial2injectconstructor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/tutorial2injectconstructor/MyApplication;", "Landroid/app/Application;", "()V", "<set-?>", "Lcom/example/tutorial2injectconstructor/di/MyComponent;", "myComponent", "getMyComponent", "()Lcom/example/tutorial2injectconstructor/di/MyComponent;", "onCreate", "", "Tutorial2-1InjectConstructor_debug"})
public final class MyApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private com.example.tutorial2injectconstructor.di.MyComponent myComponent;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tutorial2injectconstructor.di.MyComponent getMyComponent() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public MyApplication() {
        super();
    }
}