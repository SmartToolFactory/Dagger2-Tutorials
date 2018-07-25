package com.example.tutorial5_2dagger_android_subcomponents3;


import com.example.tutorial5_2dagger_android_subcomponents3.di.AppComponent;
import com.example.tutorial5_2dagger_android_subcomponents3.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        return appComponent;
    }

}
