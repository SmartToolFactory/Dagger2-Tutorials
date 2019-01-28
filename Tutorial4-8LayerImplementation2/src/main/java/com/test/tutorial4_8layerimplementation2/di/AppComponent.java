package com.test.tutorial4_8layerimplementation2.di;


import android.app.Application;

import com.test.tutorial4_8layerlibrary.di.BaseAppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * When @ContributesAndroidInjector is used ActivityContributorModule module is added to modules
 */
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BaseAppModule.class,
        ActivityContributorModule.class})

@Singleton
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}