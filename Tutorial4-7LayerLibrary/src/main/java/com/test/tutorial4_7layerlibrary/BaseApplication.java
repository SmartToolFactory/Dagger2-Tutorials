package com.test.tutorial4_7layerlibrary;

import android.app.Application;

import com.test.tutorial4_7layerlibrary.di.BaseAppComponent;
import com.test.tutorial4_7layerlibrary.di.DaggerBaseAppComponent;

public abstract class BaseApplication extends Application {

    private BaseAppComponent mBaseAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseAppComponent = DaggerBaseAppComponent
                .builder()
                .application(this)
                .build();
    }

    public BaseAppComponent getBaseAppComponent() {
        return mBaseAppComponent;
    }
}