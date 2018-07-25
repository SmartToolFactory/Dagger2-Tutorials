package com.example.tutorial5_2dagger_android_subcomponents;

import android.app.Application;

import com.example.tutorial5_2dagger_android_subcomponents.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MyApplication extends dagger.android.support.DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
