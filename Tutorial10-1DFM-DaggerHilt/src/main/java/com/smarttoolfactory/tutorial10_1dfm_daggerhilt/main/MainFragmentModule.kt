package com.smarttoolfactory.tutorial10_1dfm_daggerhilt.main

import android.app.Activity
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.MainFragmentObject
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
class MainFragmentModule {

    @Provides
    fun provideMainFragmentObject(activity: Activity) = MainFragmentObject(activity)

}