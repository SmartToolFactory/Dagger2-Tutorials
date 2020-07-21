package com.smarttoolfactory.tutorial10_1dfm_daggerhilt.home

import android.content.Context
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.HomeFragmentObject
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
class HomeFragmentModule {

    @Provides
    fun provideHomeFragmentObject(context: Context) = HomeFragmentObject(context)
}

