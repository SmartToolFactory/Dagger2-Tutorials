package com.example.tutorial4_2subcomponents.di;

import com.example.tutorial4_2subcomponents.MainActivity;
import com.example.tutorial4_2subcomponents.ToastMaker;

import dagger.Subcomponent;

/**
 *
 *  SubComponent generally used for injecting short lived objects to Activities, Fragments or other Objects
 *  !!! Only 1 Component can be injected to an Activity, Fragment or Object
 */
@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivitySubComponent {
    void inject(MainActivity mainActivity);
}
