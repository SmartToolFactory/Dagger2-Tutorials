package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main;


import android.content.SharedPreferences;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di.FragmentScope;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.MySharedPreferences;

import dagger.Module;

@Module
public abstract class MyFragmentModule {

    @FragmentScope
    static MySharedPreferences provideMySharedPreference(SharedPreferences sharedPreferences) {
        return new MySharedPreferences(sharedPreferences);
    }

}
