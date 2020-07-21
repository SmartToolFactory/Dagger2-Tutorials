package com.smarttoolfactory.tutorial9_2core.di

import android.app.Application
import com.smarttoolfactory.tutorial9_2core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial9_2core.model.CoreCameraDependency
import com.smarttoolfactory.tutorial9_2core.model.CoreDependency
import com.smarttoolfactory.tutorial9_2core.model.CorePhotoDependency
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    /*
        Provision methods to provide dependencies below to components that depends on
        CoreComponent
     */
    fun coreDependency(): CoreDependency

    fun coreCameraDependency(): CoreCameraDependency

    fun corePhotoDependency(): CorePhotoDependency

    fun coreActivityDependency(): CoreActivityDependency


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): CoreComponent
    }

}
