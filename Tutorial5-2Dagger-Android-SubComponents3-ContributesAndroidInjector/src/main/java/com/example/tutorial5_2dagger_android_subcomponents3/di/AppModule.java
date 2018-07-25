package com.example.tutorial5_2dagger_android_subcomponents3.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {

    @Provides
    @Singleton
    static SharedPreferences provideSharedPreferences(Application application) {
        System.out.println("ApplicationModule context: " + application);
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

}
