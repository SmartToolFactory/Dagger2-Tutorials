package com.test.tutorial4_7layerimplementation.di

import com.test.tutorial4_7layerimplementation.model.User
import com.test.tutorial4_7layerlibrary.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideUser() = User("Name","email")
}