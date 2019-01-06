package com.example.tutorial2injectconstructor.model;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/*
 * Without @Singleton annotation constructor injection does not inject a singleton object.
 * New instance of this object with @Inject contructor is created after each device rotation
 */
@Singleton
public class MySharedPreferences {

    private SharedPreferences mSharedPreferences;

    /*
        Here in this model class constructor injection is used as @Inject is added on the constructor.
        SharedPreferences object is passed from Module to constructor with provideSharedPreferences()
    */

    @Inject
    public MySharedPreferences(SharedPreferences mSharedPreferences) {
        System.out.println("MySharedPreferences Constructor with: " + mSharedPreferences);
        this.mSharedPreferences = mSharedPreferences;
    }

    public void putData(String key, int data) {
        mSharedPreferences.edit().putInt(key, data).apply();
    }

    public int getData(String key) {
        return mSharedPreferences.getInt(key, 0);
    }
}