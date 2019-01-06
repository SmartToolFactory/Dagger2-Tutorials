package com.example.tutorial4_4componentbuildersmultiplemodules.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModuleWithBind {

    @Provides
    @Singleton
    public SharedPreferences providePreferences(Application application) {
        return application.getSharedPreferences("data",
                Context.MODE_PRIVATE);
    }
}
