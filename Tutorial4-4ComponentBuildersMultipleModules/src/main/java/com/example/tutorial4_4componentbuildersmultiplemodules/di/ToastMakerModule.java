package com.example.tutorial4_4componentbuildersmultiplemodules.di;

import android.app.Application;

import com.example.tutorial4_4componentbuildersmultiplemodules.model.ToastMaker;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ToastMakerModule {

    @Singleton
    @Provides
    ToastMaker provideToastMaker(Application application) {
        return  new ToastMaker(application);
    }
}
