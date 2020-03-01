package com.example.tutorial4_3componentbuilders.di;

import java.lang.System;

/**
 * This module is created as it's with other examples
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/tutorial4_3componentbuilders/di/AppModule;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "providePreferences", "Landroid/content/SharedPreferences;", "Tutorial4-3ComponentBuilders_debug"})
@dagger.Module()
public final class AppModule {
    private final android.app.Application application = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final android.content.SharedPreferences providePreferences() {
        return null;
    }
    
    public AppModule(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
}