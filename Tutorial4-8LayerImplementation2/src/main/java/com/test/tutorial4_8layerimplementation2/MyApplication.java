package com.test.tutorial4_8layerimplementation2;


import com.test.tutorial4_8layerimplementation2.di.AppComponent;
import com.test.tutorial4_8layerimplementation2.di.DaggerAppComponent;
import com.test.tutorial4_8layerlibrary.BaseApplication;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MyApplication extends BaseApplication {

    @Inject
    BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

}
