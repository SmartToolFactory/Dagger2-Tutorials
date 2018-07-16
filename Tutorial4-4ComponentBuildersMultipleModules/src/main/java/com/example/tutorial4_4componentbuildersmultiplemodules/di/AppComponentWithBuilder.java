package com.example.tutorial4_4componentbuildersmultiplemodules.di;

import android.app.Application;


import com.example.tutorial4_4componentbuildersmultiplemodules.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModuleWithBuilder.class, ToastMakerModule.class, SensorControllerModule.class})

public interface AppComponentWithBuilder {
    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {

        AppComponentWithBuilder build();


        // @BindsInstance replaces Builder appModule(AppModule appModule)
        // And removes Constructor with Application AppModule(Application)

        @BindsInstance
        Builder application(Application application);
    }
}