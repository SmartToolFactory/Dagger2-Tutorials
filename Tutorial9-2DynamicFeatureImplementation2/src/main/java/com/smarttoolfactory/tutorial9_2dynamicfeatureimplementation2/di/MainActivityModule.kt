package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di

import android.app.Application
import android.content.Context
import com.smarttoolfactory.tutorial9_2core.di.scope.ActivityScope
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.MainActivityObject
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.ToastMaker
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [MainActivityBindModule::class])
class MainActivityModule {

    @Provides
    fun provideToastMaker(application: Application) = ToastMaker(application)

    @ActivityScope
    @Provides
    fun provideMainActivityObject(context: Context) = MainActivityObject(context)

}

@Module
abstract class MainActivityBindModule {

    @Binds
    abstract fun bindContext(application: Application): Context

}