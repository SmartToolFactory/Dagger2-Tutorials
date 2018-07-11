package com.example.tutorial3scope1.di;


import com.example.tutorial3scope1.model.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @ActivityScope
    @Provides
    User provideUser() {
        return new User();
    }
}