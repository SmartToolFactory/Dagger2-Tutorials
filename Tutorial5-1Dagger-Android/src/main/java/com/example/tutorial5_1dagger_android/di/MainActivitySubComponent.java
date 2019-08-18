package com.example.tutorial5_1dagger_android.di;

import com.example.tutorial5_1dagger_android.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * SubComponents can be removed in dagger-android with @ContributesAndroidInjector
 * if SubComponent and it's Builder has NO methods
 */
@Subcomponent
public interface MainActivitySubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}