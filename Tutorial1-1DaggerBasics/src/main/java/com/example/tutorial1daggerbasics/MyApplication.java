package com.example.tutorial1daggerbasics;

import android.app.Application;

import com.example.tutorial1daggerbasics.di.ApplicationComponent;
import com.example.tutorial1daggerbasics.di.ApplicationModule;
import com.example.tutorial1daggerbasics.di.DaggerMyExampleComponent;

public class MyApplication extends Application {
    private ApplicationComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyComponent = createMyComponent();
    }

    ApplicationComponent getMyComponent() {
        return mMyComponent;
    }

    private ApplicationComponent createMyComponent() {
        return DaggerMyExampleComponent.builder()
                .myExampleModule(new ApplicationModule())
                .build();
    }
}
