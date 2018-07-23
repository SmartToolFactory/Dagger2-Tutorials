package com.example.tutorial5_1dagger_android.di;


import android.app.Application;

import com.example.tutorial5_1dagger_android.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

// This is parent component
@Component(modules = {ApplicationModule.class, AndroidSupportInjectionModule.class})
@Singleton
public interface ApplicationComponent extends AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}