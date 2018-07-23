package com.example.tutorial5_1dagger_android;


import com.example.tutorial5_1dagger_android.di.DaggerApplicationComponent;

import dagger.android.AndroidInjector;

public class MyApplication extends dagger.android.support.DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends dagger.android.support.DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }
}
