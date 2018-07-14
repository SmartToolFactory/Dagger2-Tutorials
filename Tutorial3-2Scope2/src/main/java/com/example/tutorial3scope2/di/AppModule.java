package com.example.tutorial3scope2.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    Context appContext;

    public AppModule(@NonNull Context context) {
        this.appContext = context;
    }

    @Singleton
    @Provides
    Context provideAppContext() {
        return appContext;
    }
}
