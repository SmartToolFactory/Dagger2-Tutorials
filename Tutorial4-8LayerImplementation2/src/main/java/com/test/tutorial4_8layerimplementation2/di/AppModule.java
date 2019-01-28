package com.test.tutorial4_8layerimplementation2.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.test.tutorial4_8layerlibrary.di.BaseSubComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {BaseSubComponent.class})
public class AppModule {

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

}
