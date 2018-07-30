package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MyFragment;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MyFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentContributorModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = MyFragmentModule.class)
    abstract MyFragment contributeMyFragment();
}
