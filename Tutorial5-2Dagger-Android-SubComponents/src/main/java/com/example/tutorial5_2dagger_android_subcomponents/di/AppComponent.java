package com.example.tutorial5_2dagger_android_subcomponents.di;

import android.app.Application;

import com.example.tutorial5_2dagger_android_subcomponents.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/*
 * Differences between AppComponent of dagger-android and regular dagger:
 *
 *  1- Binds AndroidSupportInjectionModule.class in modules
 *  2- Extends AndroidInjector<MyApplication>
 *  3- Does not have @Subcomponent.Builder to inject to classes inside Sub-Component
 */
@Component(modules = {AppModule.class, AndroidSupportInjectionModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}