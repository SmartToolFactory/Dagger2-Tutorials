package com.example.tutorial4_4componentbuildersmultiplemodules.di;


import com.example.tutorial4_4componentbuildersmultiplemodules.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ToastMakerModule.class, SensorControllerModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    // DaggerAppComponent.build() returns this Builder interface

    @Component.Builder
    interface Builder {
        AppComponent build();

        Builder appModule(AppModule appModule);

        Builder sensorControllerModule(SensorControllerModule sensorControllerModule);

        Builder toastMakerModule(ToastMakerModule toastMakerModule);
    }

}