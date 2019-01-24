package com.example.tutorial1basics3.di;

import com.example.tutorial1basics3.MyApplication;
import com.example.tutorial1basics3.model.SensorController;
import com.example.tutorial1basics3.model.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppContextModule {
    private final MyApplication mMyApplication;

    public AppContextModule(MyApplication context) {
        mMyApplication = context;
    }

    // @Singleton annotation for application object is not necessary since it's already a singleton object of Android
    @Singleton
    @Provides
    MyApplication provideMyApplication() {
        return mMyApplication;
    }

    // This is a singleton object at application level
    @Singleton
    @Provides
    User provideUser() {
        return new User();
    }

    // This is not a singleton object
    @Provides
    SensorController provideSensorController() {
        return new SensorController(mMyApplication);
    }


}
