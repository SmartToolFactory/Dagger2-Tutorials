package com.example.tutorial2injectconstructor.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tutorial2injectconstructor.model.MySharedPreferences;

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

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }
}