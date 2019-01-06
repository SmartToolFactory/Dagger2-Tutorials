package com.example.tutorial4_3componentbuilders;

import android.app.Application;

import com.example.tutorial4_3componentbuilders.di.AppComponent;
import com.example.tutorial4_3componentbuilders.di.AppComponentWithBuilder;
import com.example.tutorial4_3componentbuilders.di.AppModule;
import com.example.tutorial4_3componentbuilders.di.DaggerAppComponent;
import com.example.tutorial4_3componentbuilders.di.DaggerAppComponentWithBuilder;

public class MyApplication extends Application {

    private AppComponent appComponent;

    private AppComponentWithBuilder appComponentWithBuilder;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();

        appComponentWithBuilder = DaggerAppComponentWithBuilder
                .builder()
                .application(this)
                .build();

    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponentWithBuilder getAppComponentWithBuilder() {
        return appComponentWithBuilder;
    }
}
