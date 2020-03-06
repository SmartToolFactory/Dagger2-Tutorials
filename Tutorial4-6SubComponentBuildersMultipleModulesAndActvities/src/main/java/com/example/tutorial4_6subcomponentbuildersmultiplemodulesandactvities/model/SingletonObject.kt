package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.ApplicationComponent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * * 🔥 Returns Singleton if it has same scope [ApplicationComponent] has.
 *
 * * 🔥 If un-scoped NEW instance of [SingletonObject] is created
 * whenever an Activity/Fragment/Object is recreated.
 *
 * * 🔥 If a scope different than [ApplicationComponent], for this example
 * it's injected to @ActivityScope and @FragmentScope activity and fragments
 * so it can't have neither of them(sub component scope) in this example
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