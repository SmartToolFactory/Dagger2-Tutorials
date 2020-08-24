package com.smarttoolfactory.tutorial8_3daggerhilt_definecomponent.di

import com.smarttoolfactory.tutorial8_3daggerhilt_definecomponent.model.ApplicationObject
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@InstallIn(ApplicationComponent::class)
@Module
class AppModule {

    fun provideApplicationObject() = ApplicationObject()

}