package com.example.tutorial4_5subcomponentbuilders;

import android.app.Application;

import com.example.tutorial4_5subcomponentbuilders.di.ApplicationComponent;
import com.example.tutorial4_5subcomponentbuilders.di.ApplicationModule;
import com.example.tutorial4_5subcomponentbuilders.di.DaggerApplicationComponent;


public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
