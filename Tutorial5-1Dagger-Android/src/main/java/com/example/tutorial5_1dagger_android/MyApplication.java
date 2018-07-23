package com.example.tutorial5_1dagger_android;



import com.example.tutorial5_1dagger_android.di.AppComponent;
import com.example.tutorial5_1dagger_android.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        return appComponent;
    }

}
