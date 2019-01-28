package com.example.tutorial4_4componentbuildersmultiplemodules.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences providePreferences() {
        return application.getSharedPreferences("store",
                Context.MODE_PRIVATE);
    }
}
