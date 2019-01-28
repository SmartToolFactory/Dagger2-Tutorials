package com.test.tutorial4_8layerimplementation2;


import com.test.tutorial4_8layerimplementation2.di.AppComponent;
import com.test.tutorial4_8layerimplementation2.di.DaggerAppComponent;
import com.test.tutorial4_8layerlibrary.BaseApplication;

public class MyApplication extends BaseApplication {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
