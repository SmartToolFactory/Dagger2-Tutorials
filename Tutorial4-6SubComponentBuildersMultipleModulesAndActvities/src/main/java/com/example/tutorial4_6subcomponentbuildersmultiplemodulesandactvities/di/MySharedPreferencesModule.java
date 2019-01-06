package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.MySharedPreferences;

import dagger.Module;

// This is SubComponent Module

@Module
public class MySharedPreferencesModule {

    @FragmentScope
    MySharedPreferences provideMySharedPreference(SharedPreferences sharedPreferences) {
        return  new MySharedPreferences(sharedPreferences);
    }
}
