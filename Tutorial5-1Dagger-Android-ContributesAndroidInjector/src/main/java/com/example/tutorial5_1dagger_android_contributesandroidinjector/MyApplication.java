package com.example.tutorial5_1dagger_android_contributesandroidinjector;


import com.example.tutorial5_1dagger_android_contributesandroidinjector.di.AppComponent;
import com.example.tutorial5_1dagger_android_contributesandroidinjector.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        return appComponent;
    }

}
