package com.example.tutorial5_1daggerandroid.di;


import android.content.Context;

import com.example.tutorial5_1daggerandroid.MainActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {ToastMakerModule.class})
public interface ToastMakerSubComponent extends AndroidInjector<MainActivity> {


    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

        @Override
        public void seedInstance(MainActivity instance) {
            context(instance);
        }

        @BindsInstance
        public abstract Builder context(Context context);
    }
}