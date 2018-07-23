package com.example.tutorial5_1dagger_android.di;


import android.content.Context;

import com.example.tutorial5_1dagger_android.MainActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {ToastMakerModule.class})
public interface ToastMakerSubComponent extends AndroidInjector<MainActivity> {


    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

        // It gets concrete type instance from AndroidInjector<T>

        /*
            These 2 methods get Context from MainActivity
          */
        @Override
        public void seedInstance(MainActivity instance) {
            context(instance);
        }

        @BindsInstance
        public abstract Builder context(Context context);
    }

}