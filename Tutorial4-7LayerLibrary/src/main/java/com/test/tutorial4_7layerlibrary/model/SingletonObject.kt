package com.test.tutorial4_7layerlibrary.model


import javax.inject.Inject
import javax.inject.Singleton

/**
 * * 🔥 Returns Singleton if it has same scope [ApplicationComponent] has.
 *
 * * 🔥 If un-scoped NEW instance of [SingletonObject] is created
 * whenever an Activity/Fragment/Object is recreated.
 *
 * * 🔥 If a scope different other than [ApplicationComponent] is used, in this example
 * it's injected to @ActivityScope scoped [MainActivity], [SecondActivity] and @FragmentScope scoped [FirstFragment]
 * so it can't have neither of these scopes(sub component scope)
 * it returns ERROR:
 * ToastMakerSubComponent scoped with @ActivityScope
 * may not reference bindings with different scopes
 *
 * 🔥 If not injected to [MainActivity] it could ONLY have @ActivityScope without error because [SecondActivity]
 * uses only @FragmentScope
 *
 * */
@Singleton
class SingletonObject @Inject constructor() {

    fun logSingletonObject() {
        println("SingletonObject logSingletonObject() $this")
    }
}