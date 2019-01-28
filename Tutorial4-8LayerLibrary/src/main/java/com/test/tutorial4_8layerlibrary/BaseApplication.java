package com.test.tutorial4_8layerlibrary;

import java.util.Random;

import dagger.android.support.DaggerApplication;

public abstract class BaseApplication extends DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();
    }


    public int testResult() {
        Random random = new Random();
        return random.nextInt(100);
    }

}