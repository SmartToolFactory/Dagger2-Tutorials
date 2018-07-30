package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di.AppComponent;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        return appComponent;
    }

}
