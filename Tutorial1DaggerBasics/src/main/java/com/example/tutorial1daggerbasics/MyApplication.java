package com.example.tutorial1daggerbasics;

import android.app.Application;

import com.example.tutorial1daggerbasics.di.DaggerMyExampleComponent;
import com.example.tutorial1daggerbasics.di.MyExampleComponent;
import com.example.tutorial1daggerbasics.di.MyExampleModule;

public class MyApplication extends Application {
    private MyExampleComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyComponent = createMyComponent();
    }

    MyExampleComponent getMyComponent() {
        return mMyComponent;
    }

    private MyExampleComponent createMyComponent() {
        return DaggerMyExampleComponent.builder()
                .myExampleModule(new MyExampleModule())
                .build();
    }
}
