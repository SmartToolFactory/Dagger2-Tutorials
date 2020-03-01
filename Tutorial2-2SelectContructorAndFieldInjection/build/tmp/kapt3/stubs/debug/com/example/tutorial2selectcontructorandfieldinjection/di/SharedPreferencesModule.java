package com.example.tutorial2selectcontructorandfieldinjection.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/tutorial2selectcontructorandfieldinjection/di/SharedPreferencesModule;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "provideMySharedPreferences", "Lcom/example/tutorial2selectcontructorandfieldinjection/model/MySharedPreferences;", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "Tutorial2-2SelectContructorAndFieldInjection_debug"})
@dagger.Module()
public final class SharedPreferencesModule {
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final android.content.SharedPreferences provideSharedPreferences() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    @javax.inject.Named(value = "Field")
    public final com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences provideMySharedPreferences() {
        return null;
    }
    
    public SharedPreferencesModule(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}