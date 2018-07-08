package com.example.tutorial2injectconstructor;

import android.app.Application;

import com.example.tutorial2injectconstructor.di.DaggerMyComponent;
import com.example.tutorial2injectconstructor.di.MyComponent;
import com.example.tutorial2injectconstructor.di.SharedPreferencesModule;

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