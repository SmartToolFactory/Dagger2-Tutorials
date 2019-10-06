package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main.MainActivity;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main.MyFragment;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main.MyFragmentModule;

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
     *
     *  <p></p>
     *  Scope of @ContributesAndroidInjector methods and their modules should be same.
     * Otherwise app returns HAS CONFLICTING SCOPES error
     *
     */
    @FragmentScope
    @ContributesAndroidInjector(modules = MyFragmentModule.class)
    abstract MyFragment contributeMyFragment();
}
