package com.smarttoolfactory.tutorial10_1core.di

import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreLeaderboardDependency
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface CoreComponent {

    /*
        Provision methods to provide dependencies below to components that depends on
        CoreComponent
     */
    fun coreDependency(): CoreDependency

    fun coreActivityDependency(): CoreActivityDependency

    fun coreLeaderboardDependency(): CoreLeaderboardDependency

}
