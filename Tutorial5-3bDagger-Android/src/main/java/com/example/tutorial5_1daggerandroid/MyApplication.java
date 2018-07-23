package com.example.tutorial5_1daggerandroid;

import com.example.tutorial5_1daggerandroid.di.DaggerApplicationComponent;

import dagger.android.AndroidInjector;

public class MyApplication extends dagger.android.support.DaggerApplication {

    @Override
    protected AndroidInjector<? extends dagger.android.support.DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.create();
    }
}
