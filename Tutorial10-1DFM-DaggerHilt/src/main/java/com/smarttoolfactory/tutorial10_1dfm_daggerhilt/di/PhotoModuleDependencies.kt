package com.smarttoolfactory.tutorial10_1dfm_daggerhilt.di

import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.MainActivityObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.ToastMaker
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface PhotoModuleDependencies {

    fun toastMaker(): ToastMaker

    fun mainActivityObject(): MainActivityObject
}