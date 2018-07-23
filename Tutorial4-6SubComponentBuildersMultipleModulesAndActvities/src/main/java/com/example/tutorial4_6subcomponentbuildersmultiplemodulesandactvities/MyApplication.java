package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities;

import android.app.Application;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.ApplicationComponent;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.DaggerApplicationComponent;

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().application(this).build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
