package com.example.tutorial4_2subcomponents;

import android.app.Application;

import com.example.tutorial4_2subcomponents.di.ApplicationComponent;
import com.example.tutorial4_2subcomponents.di.DaggerApplicationComponent;
import com.example.tutorial4_2subcomponents.di.SharedPreferencesModule;

public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .sharedPreferencesModule(new SharedPreferencesModule(getApplicationContext()))
                .build();

        //   mApplicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
