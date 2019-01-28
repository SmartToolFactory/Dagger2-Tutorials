package com.example.tutorial3scope2;

import android.app.Application;

import com.example.tutorial3scope2.di.DaggerMyComponent;
import com.example.tutorial3scope2.di.MyComponent;
import com.example.tutorial3scope2.di.SharedPreferencesModule;


public class MyApplication extends Application {
    private MyComponent myComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        myComponent = DaggerMyComponent.builder()
                .sharedPreferencesModule(new SharedPreferencesModule(getApplicationContext()))
                .build();

    }

    public MyComponent getMyComponent() {
        return myComponent;
    }
}