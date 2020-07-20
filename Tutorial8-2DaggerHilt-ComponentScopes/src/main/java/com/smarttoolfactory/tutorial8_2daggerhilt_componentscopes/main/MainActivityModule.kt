package com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.main

import android.content.Context
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model.ToastMaker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped


@InstallIn(ActivityComponent::class)
@Module
class MainActivityModule {

    @ActivityScoped
    @Provides
    fun provideToastMaker(@ApplicationContext context: Context): ToastMaker {
        return ToastMaker(context)
    }

}