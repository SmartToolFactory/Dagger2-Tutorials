package com.example.tutorial4_3componentbuilders.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModuleWithBuilder {

    @Provides
    @Singleton
    public SharedPreferences providePreferences(Application application) {
        return application.getSharedPreferences("data",
                Context.MODE_PRIVATE);
    }
}
