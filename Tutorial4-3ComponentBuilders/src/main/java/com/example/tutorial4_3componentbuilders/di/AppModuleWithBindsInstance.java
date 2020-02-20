package com.example.tutorial4_3componentbuilders.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModuleWithBindsInstance {

    /*
     * Application is provided from DaggerAppComponentWithBindsInstance.builder().application(this) in MyApplication class
     * AppComponent with @BindsInstance binds Application to all classes that require Application
     */
    @Provides
    @Singleton
    public SharedPreferences providePreferences(Application application) {
        return application.getSharedPreferences("data",
                Context.MODE_PRIVATE);
    }
}
