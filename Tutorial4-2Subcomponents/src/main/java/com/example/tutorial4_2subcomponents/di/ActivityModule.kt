package com.example.tutorial4_2subcomponents.di

import com.example.tutorial4_2subcomponents.MainActivity
import com.example.tutorial4_2subcomponents.model.ToastMaker
import dagger.Module
import dagger.Provides

/**
 * This is the module of sub-component [ActivitySubComponent]
 */
@Module
class ActivityModule(private val mainActivity: MainActivity) {

    @ActivityScope
    @Provides
    fun provideToastMaker(): ToastMaker {
        return ToastMaker(mainActivity)
    }

}