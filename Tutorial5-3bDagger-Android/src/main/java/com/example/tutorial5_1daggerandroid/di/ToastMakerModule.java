package com.example.tutorial5_1daggerandroid.di;


import android.content.Context;

import com.example.tutorial5_1daggerandroid.ToastMaker;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

// This is SubComponent Module

@Module
public class ToastMakerModule {

    @ActivityScope
    @Provides
    ToastMaker provideToastMaker(Context context) {
        System.out.println("ToastMakerModule context: " + context);
        return new ToastMaker(context);
    }
}