package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MainActivity;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MyFragment;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MyFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentContributorModule {

    /**
     * FragmentContributorModule is used inside ActivityContributorModule
     * With @ContributesAndroidInjector(modules = MyFragmentModule.class)
     * defines which module will be used to inject objects to MyFragment
     * <p>
     * In this example {@link MainActivity} has {@link MyFragment} fragment, and {@link MyFragment}
     * uses {@link MyFragmentModule} to inject objects
     */
    @FragmentScope
    @ContributesAndroidInjector(modules = MyFragmentModule.class)
    abstract MyFragment contributeMyFragment();
}
