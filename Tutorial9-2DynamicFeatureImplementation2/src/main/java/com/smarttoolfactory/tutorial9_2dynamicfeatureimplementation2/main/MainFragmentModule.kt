package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.main

import android.app.Activity
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.MainFragmentObject
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {

    @Provides
    fun provideMainFragmentObject(activity: Activity) = MainFragmentObject(activity)
}