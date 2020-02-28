package com.smarttoolfactory.tutorial6_1componentfactory.di

import android.app.Application
import com.smarttoolfactory.tutorial6_1componentfactory.model.DefaultToastMaker
import dagger.Module
import dagger.Provides


@Module
class AppModule {

    @Provides
    fun provideDefaultToastMaker(application: Application): DefaultToastMaker {
        return DefaultToastMaker(application)
    }


}