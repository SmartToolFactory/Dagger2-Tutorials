package com.smarttoolfactory.tutorial10_1dfm_daggerhilt.di

import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.MainActivityObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.ToastMaker
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface PhotoModuleDependencies {

    /*
        CoreModule dependencies from core module
     */
    fun coreDependency(): CoreDependency

    fun coreActivityDependency(): CoreActivityDependency


    /*
        MainActivityModule dependencies from app module
     */
    fun toastMaker(): ToastMaker

    fun mainActivityObject(): MainActivityObject
}