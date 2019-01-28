package com.test.tutorial4_8layerimplementation2.di;


import com.test.tutorial4_8layerimplementation2.MainActivity;
import com.test.tutorial4_8layerlibrary.di.ActivityScope;
import com.test.tutorial4_8layerlibrary.di.BaseActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityContributorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class, BaseActivityModule.class})
    abstract MainActivity contributeMainActivity();

}
