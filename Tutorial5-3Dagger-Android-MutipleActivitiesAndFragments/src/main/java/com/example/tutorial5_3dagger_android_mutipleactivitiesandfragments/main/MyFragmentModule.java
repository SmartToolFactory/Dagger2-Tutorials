package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main;


import android.content.SharedPreferences;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di.FragmentScope;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.MySharedPreferences;

import dagger.Module;


/**
 * Scope of @ContributesAndroidInjector methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 */
@Module
public abstract class MyFragmentModule {

    @FragmentScope
    static MySharedPreferences provideMySharedPreference(SharedPreferences sharedPreferences) {
        return new MySharedPreferences(sharedPreferences);
    }

}
