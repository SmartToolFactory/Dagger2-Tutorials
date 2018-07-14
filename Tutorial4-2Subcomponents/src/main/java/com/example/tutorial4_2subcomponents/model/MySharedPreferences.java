package com.example.tutorial4_2subcomponents.model;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class MySharedPreferences {

    private SharedPreferences mSharedPreferences;

    /*
        Here in this model class constructor injection is used as @Inject is added on the constructor.
        SharedPreferences object is passed from Module to constructor with provideSharedPreferences()
    */

    @Inject
    public MySharedPreferences(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    public void putData(String key, int data) {
        mSharedPreferences.edit().putInt(key, data).apply();
    }

    public int getData(String key) {
        return mSharedPreferences.getInt(key, 0);
    }
}