package com.example.tutorial3scope1;

import android.app.Application;

import com.example.tutorial3scope1.di.DaggerUserComponent;
import com.example.tutorial3scope1.di.UserComponent;


public class MyApplication extends Application {

    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        userComponent = DaggerUserComponent.create();
    }


    public UserComponent getUserComponent() {
        return userComponent;
    }
}
