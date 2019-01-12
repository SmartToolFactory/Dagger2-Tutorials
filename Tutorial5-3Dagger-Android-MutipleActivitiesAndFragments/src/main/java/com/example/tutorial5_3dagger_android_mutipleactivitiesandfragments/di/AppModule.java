package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * AppModule of dagger-android with @ContributesAndroidInjector
 * does not declare sub-components inside @Module annotation
 *
 * @Module(subcomponents = {A.class, B.class}) is not used
 */

@Module
public abstract class AppModule {

    @Provides
    @Singleton
    static SharedPreferences provideSharedPreferences(Application application) {
        System.out.println("ApplicationModule context: " + application);
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

}
