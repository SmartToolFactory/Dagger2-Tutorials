package com.test.tutorial4_8layerimplementation2.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.test.tutorial4_8layerlibrary.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {

    @Singleton
    @Provides
    static SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    static BaseApplication providesBaseApplication(Application application) {
        return (BaseApplication) application;
    }

}
