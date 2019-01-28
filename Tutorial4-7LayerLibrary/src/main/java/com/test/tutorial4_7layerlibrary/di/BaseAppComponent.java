package com.test.tutorial4_7layerlibrary.di;


import android.app.Application;

import com.test.tutorial4_7layerlibrary.BaseActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = BaseAppModule.class)
public interface BaseAppComponent {

    void inject(BaseActivity baseActivity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        BaseAppComponent build();

    }
}