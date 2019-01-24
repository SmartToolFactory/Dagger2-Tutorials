package com.example.tutorial3scope2.model;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Scope of Injected class depends on the component of the class it's injeceted to
 * {@link com.example.tutorial2selectcontructorandfieldinjection.di.MyComponent} is injected to {@link com.example.tutorial2selectcontructorandfieldinjection.MainActivity}
 * scope pf this class only be same as MyComponent's scope or unscoped.
 * <p>
 * Error when this class is scoped: MyComponent scoped with @Singleton may not reference bindings with different scopes
 * </p>
 */
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