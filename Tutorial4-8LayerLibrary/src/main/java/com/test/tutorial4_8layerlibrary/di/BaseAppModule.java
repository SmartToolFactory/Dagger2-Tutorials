package com.test.tutorial4_8layerlibrary.di;

import android.app.Application;

import com.test.tutorial4_8layerlibrary.model.ToastMaker;
import com.test.tutorial4_8layerlibrary.model.User;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseAppModule {

    @ActivityScope
    @Provides
    User provideUser() {
        return new User("Unknown", "abc@xyz.com");
    }

    @ActivityScope
    @Provides
    ToastMaker provideToastMaker(Application application) {
        return new ToastMaker(application);
    }

}
