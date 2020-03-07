package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di

import android.app.Application
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main.MainActivitySubComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * This component has [AppModule] for @Singleton scope injected objects and
 * [ActivitySubComponentsModule] to create sub-scopes at Activity level
 */
// This is parent component
@Component(modules = [
    AppModule::class,
    ActivitySubComponentsModule::class
])
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    // Types that can be retrieved from the graph
    fun mainActivityComponentFactory(): MainActivitySubComponent.Factory


}