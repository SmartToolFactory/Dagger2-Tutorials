package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MainActivity;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MyFragment;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di.FragmentScope;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.MySharedPreferences;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.ToastMaker;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MyFragmentModule {

    @FragmentScope
    static MySharedPreferences provideMySharedPreference(SharedPreferences sharedPreferences) {
        return  new MySharedPreferences(sharedPreferences);
    }

}
