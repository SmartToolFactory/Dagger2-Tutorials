package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di;


import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main.MainActivity;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main.MainActivityModule;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.second.SecondActivity;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.second.SecondActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * {@link MainActivity} declares {@link MainActivityModule} to inject dependencies provided in {@link MainActivityModule}
 * To be able to inject dependencies to fragments inside {@link MainActivity} it defines {@link FragmentContributorModule}
 *
 * <p></p>
 * contributeMainActivity method with @ContributesAndroidInjector
 * annotation replaces MainActivityComponent of non dagger-android.
 * <p></p>
 * @ContributesAndroidInjector replaces MainActivitySubComponent
 * if the sub-component and it's builder has NO methods.
 * <p></p>
 *
 * Scope of contributor methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 *
 */

@Module
public abstract class ActivityContributorModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentContributorModule.class})
    abstract MainActivity contributeMainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {SecondActivityModule.class})
    abstract SecondActivity contributeSecondActivity();


}
