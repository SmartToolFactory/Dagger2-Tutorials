package com.example.tutorial4_4componentbuildersmultiplemodules;

import android.app.Application;

import com.example.tutorial4_4componentbuildersmultiplemodules.di.AppComponent;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.AppComponentWithBuilder;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.AppModule;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.DaggerAppComponent;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.DaggerAppComponentWithBuilder;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.SensorControllerModule;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.ToastMakerModule;

public class MyApplication extends Application {

    private AppComponent appComponent;

    private AppComponentWithBuilder appComponentWithBuilder;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .sensorControllerModule(new SensorControllerModule())
                .toastMakerModule(new ToastMakerModule())
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
