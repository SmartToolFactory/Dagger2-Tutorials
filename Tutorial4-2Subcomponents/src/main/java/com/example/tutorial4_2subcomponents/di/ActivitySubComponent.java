package com.example.tutorial4_2subcomponents.di;

import com.example.tutorial4_2subcomponents.MainActivity;
import com.example.tutorial4_2subcomponents.ToastMaker;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivitySubComponent {
    void inject(MainActivity mainActivity);
}
