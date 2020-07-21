package com.smarttoolfactory.tutorial10_1dfm_daggerhilt.di

import android.app.Application
import android.content.Context
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.MainActivityObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.ToastMaker

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module(includes = [MainActivityBindModule::class])
class MainActivityModule {

    @Provides
    fun provideToastMaker(application: Application) = ToastMaker(application)

    @ActivityScoped
    @Provides
    fun provideMainActivityObject(context: Context) = MainActivityObject(context)

}

@InstallIn(ActivityComponent::class)
@Module
abstract class MainActivityBindModule {

    @Binds
    abstract fun bindContext(application: Application): Context

}