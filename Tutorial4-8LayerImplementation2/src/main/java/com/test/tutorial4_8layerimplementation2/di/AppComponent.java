package com.test.tutorial4_8layerimplementation2.di;


import android.app.Application;

import com.test.tutorial4_8layerimplementation2.MainActivity;
import com.test.tutorial4_8layerlibrary.BaseActivity;
import com.test.tutorial4_8layerlibrary.di.BaseAppModule;
import com.test.tutorial4_8layerlibrary.di.BaseSubComponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    BaseSubComponent.Builder baseComponentBuilder();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }
}
