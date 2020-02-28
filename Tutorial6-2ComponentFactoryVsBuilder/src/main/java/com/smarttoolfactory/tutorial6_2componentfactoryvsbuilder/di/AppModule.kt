package com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.di

import android.app.Application
import com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.model.DefaultToastMaker
import dagger.Module
import dagger.Provides


@Module
class AppModule {

    @Provides
    fun provideDefaultToastMaker(application: Application): DefaultToastMaker {
        return DefaultToastMaker(application)
    }


}