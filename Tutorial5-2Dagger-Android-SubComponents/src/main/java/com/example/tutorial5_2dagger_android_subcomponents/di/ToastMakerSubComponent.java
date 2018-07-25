package com.example.tutorial5_2dagger_android_subcomponents.di;

import android.content.Context;

import com.example.tutorial5_2dagger_android_subcomponents.MainActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {ToastMakerModule.class})
public interface ToastMakerSubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
