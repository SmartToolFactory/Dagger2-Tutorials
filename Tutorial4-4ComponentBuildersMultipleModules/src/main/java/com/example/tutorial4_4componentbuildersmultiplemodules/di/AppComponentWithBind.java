package com.example.tutorial4_4componentbuildersmultiplemodules.di;

import android.app.Application;


import com.example.tutorial4_4componentbuildersmultiplemodules.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModuleWithBind.class, ToastMakerModule.class, SensorControllerModule.class})

public interface AppComponentWithBind {
    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {

        AppComponentWithBind build();

        // @BindsInstance replaces Builder appModule(AppModule appModule)
        // And removes Constructor with Application AppModule(Application)

        @BindsInstance
        Builder application(Application application);
    }
}