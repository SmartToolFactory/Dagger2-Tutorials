package com.example.tutorial4_3componentbuilders;

import android.app.Application;

import com.example.tutorial4_3componentbuilders.di.AppComponent;
import com.example.tutorial4_3componentbuilders.di.AppComponentWithBindsInstance;
import com.example.tutorial4_3componentbuilders.di.AppModule;
import com.example.tutorial4_3componentbuilders.di.DaggerAppComponent;
import com.example.tutorial4_3componentbuilders.di.DaggerAppComponentWithBindsInstance;

public class MyApplication extends Application {

    private AppComponent appComponent;

    private AppComponentWithBindsInstance appComponentWithBindsInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();

        appComponentWithBindsInstance = DaggerAppComponentWithBindsInstance
                .builder()
                .application(this)
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponentWithBindsInstance getAppComponentWithBindsInstance() {
        return appComponentWithBindsInstance;
    }
}
