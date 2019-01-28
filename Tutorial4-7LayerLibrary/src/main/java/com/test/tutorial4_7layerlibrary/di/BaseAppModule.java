package com.test.tutorial4_7layerlibrary.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.test.tutorial4_7layerlibrary.model.ToastMaker;
import com.test.tutorial4_7layerlibrary.model.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class BaseAppModule {

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    User provideUser() {
        return  new User("Unknown","abc@xyz.com");
    }

    @Singleton
    @Provides
    ToastMaker provideToastMaker(Application application) {
        return new ToastMaker(application);
    }

}