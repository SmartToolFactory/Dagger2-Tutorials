package com.example.tutorial5_2dagger_android_subcomponents3.di;

import android.app.Application;

import com.example.tutorial5_2dagger_android_subcomponents3.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityContributorModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}