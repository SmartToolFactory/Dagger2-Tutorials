package com.smarttoolfactory.tutorial10_1core.di

import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreCameraDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import com.smarttoolfactory.tutorial10_1core.model.CorePhotoDependency
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * This component is required for adding component to DFM dependencies
 */
@EntryPoint
@InstallIn(ApplicationComponent::class)
interface CoreComponent {

    /*
        🔥 Provision methods to provide dependencies to components that depend on this component
     */
    fun coreDependency(): CoreDependency

    fun coreActivityDependency(): CoreActivityDependency

    fun coreCameraDependency(): CoreCameraDependency

    fun corePhotoDependency(): CorePhotoDependency


}
