package com.example.tutorial5_2dagger_android_subcomponents3.di;



import com.example.tutorial5_2dagger_android_subcomponents3.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityContributorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity contributeMainActivity();

}
