package com.example.tutorial4_4componentbuildersmultiplemodules;

import android.app.Application;

import com.example.tutorial4_4componentbuildersmultiplemodules.di.AppComponent;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.AppComponentWithBind;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.AppModule;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.DaggerAppComponent;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.DaggerAppComponentWithBind;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.SensorControllerModule;
import com.example.tutorial4_4componentbuildersmultiplemodules.di.ToastMakerModule;

public class MyApplication extends Application {

    private AppComponent appComponent;

    private AppComponentWithBind appComponentWithBuilder;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .sensorControllerModule(new SensorControllerModule())
                .toastMakerModule(new ToastMakerModule())
                .build();


        appComponentWithBuilder = DaggerAppComponentWithBind
                .builder()
                .application(this)
                .build();

    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponentWithBind getAppComponentWithBuilder() {
        return appComponentWithBuilder;
    }
}
