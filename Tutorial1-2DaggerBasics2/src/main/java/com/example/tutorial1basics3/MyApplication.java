package com.example.tutorial1basics3;

import android.app.Application;

import com.example.tutorial1basics3.di.AppContextComponent;
import com.example.tutorial1basics3.di.AppContextModule;
import com.example.tutorial1basics3.di.DaggerAppContextComponent;

public class MyApplication extends Application {

    private AppContextComponent mAppContextComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppContextComponent = DaggerAppContextComponent
                .builder()
                .appContextModule(new AppContextModule(this))
                .build();
    }


    public AppContextComponent getAppContextComponent() {
        return mAppContextComponent;
    }
}
