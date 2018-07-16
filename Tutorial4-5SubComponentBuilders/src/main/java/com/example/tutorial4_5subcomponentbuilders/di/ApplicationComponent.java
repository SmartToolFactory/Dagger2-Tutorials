package com.example.tutorial4_5subcomponentbuilders.di;


import javax.inject.Singleton;

import dagger.Component;

// This is parent component
@Component(modules = ApplicationModule.class)
@Singleton
public interface ApplicationComponent {

    // Calls SubComponent Builder from MainActivity using ApplicationComponent
    ToastMakerSubComponent.Builder toastMakerBuilder();
}