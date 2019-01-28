package com.example.tutorial5_1dagger_android.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/*
 * Differences between AppComponent of dagger-android and regular dagger:
 *
 *  1- Binds AndroidSupportInjectionModule.class in modules
 *  2- Extends AndroidInjector<MyApplication>
 *  3- Does not have sub-component builder to inject to classes inside sub-component
 *  DummyDependencyComponent.Builder dummyDependencyBuilder(); is not required in app component
 */

@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class})

public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
