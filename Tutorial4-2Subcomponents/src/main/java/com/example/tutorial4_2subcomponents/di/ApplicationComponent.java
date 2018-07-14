package com.example.tutorial4_2subcomponents.di;


import com.example.tutorial4_2subcomponents.MyApplication;

import javax.inject.Singleton;

import dagger.Component;

// This is parent component
@Component(modules = SharedPreferencesModule.class)
@Singleton
public interface ApplicationComponent {

    // TODO Cannot be injected to Activity with Sub-Component
    // Not used in this example
    void inject(MyApplication myApplication);

    // factory method to instantiate the sub-component defined here (passing in the module instance)
    ActivitySubComponent newActivitySubComponent(ActivityModule activityModule);
}