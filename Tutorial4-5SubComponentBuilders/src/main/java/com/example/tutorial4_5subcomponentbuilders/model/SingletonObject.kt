package com.example.tutorial4_5subcomponentbuilders.model

import com.example.tutorial4_5subcomponentbuilders.di.ApplicationComponent
import com.example.tutorial4_5subcomponentbuilders.di.ToastMakerSubComponent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * * 🔥 Returns Singleton if it has same scope [ApplicationComponent] has.
 *
 * * 🔥 If un-scoped  or has scope(@ActivityScope in this example)
 * of [ToastMakerSubComponent] NEW instance of [SingletonObject] is created
 * whenever an Activity/Fragment/Object is recreated.
 *
 * * 🔥 If a scope different than [ApplicationComponent] and [ToastMakerSubComponent]
 * it returns ERROR ->
 * ToastMakerSubComponent scoped with @ActivityScope
 * may not reference bindings with different scopes
 *
 */
@Singleton
class SingletonObject @Inject constructor() {

    fun logSingletonObject() {
        println("SingletonObject logSingletonObject() $this")
    }
}