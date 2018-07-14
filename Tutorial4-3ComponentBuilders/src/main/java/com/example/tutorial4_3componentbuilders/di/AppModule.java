package com.example.tutorial4_3componentbuilders.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This module is created as it's with other examples
 */

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public SharedPreferences providePreferences() {
        return application.getSharedPreferences("store",
                Context.MODE_PRIVATE);
    }
}
