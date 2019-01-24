package com.example.tutorial2selectcontructorandfieldinjection.di;

import android.content.Context;
import android.content.SharedPreferences;


import com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferencesModule {

    private Context context;

    public SharedPreferencesModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

    // Field Injection for MySharedPreferences
    @Named("Field")
    @Singleton
    @Provides
    MySharedPreferences provideMySharedPreferences() {
        return new MySharedPreferences(context.getSharedPreferences("Constructor", Context.MODE_PRIVATE));
    }
}