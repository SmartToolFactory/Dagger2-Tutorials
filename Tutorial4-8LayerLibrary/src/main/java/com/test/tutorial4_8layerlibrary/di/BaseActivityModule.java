package com.test.tutorial4_8layerlibrary.di;

import com.test.tutorial4_8layerlibrary.model.User;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule {

    @ActivityScope
    @Provides
    static User provideUser() {
        return new User("Unknown", "abc@xyz.com");
    }

}
