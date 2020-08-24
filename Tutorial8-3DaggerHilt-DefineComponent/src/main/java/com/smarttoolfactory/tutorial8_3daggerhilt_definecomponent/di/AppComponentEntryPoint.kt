package com.smarttoolfactory.tutorial8_3daggerhilt_definecomponent.di

import com.smarttoolfactory.tutorial8_3daggerhilt_definecomponent.model.ApplicationObject
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn


@InstallIn(AppComponent::class)
@EntryPoint
interface AppComponentEntryPoint {
    fun applicationObject(): ApplicationObject
}
