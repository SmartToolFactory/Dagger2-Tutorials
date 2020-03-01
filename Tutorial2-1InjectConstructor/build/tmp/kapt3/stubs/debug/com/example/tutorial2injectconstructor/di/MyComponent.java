package com.example.tutorial2injectconstructor.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/tutorial2injectconstructor/di/MyComponent;", "", "inject", "", "mainActivity", "Lcom/example/tutorial2injectconstructor/MainActivity;", "Tutorial2-1InjectConstructor_debug"})
@javax.inject.Singleton()
@dagger.Component(modules = {com.example.tutorial2injectconstructor.di.SharedPreferencesModule.class})
public abstract interface MyComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.tutorial2injectconstructor.MainActivity mainActivity);
}