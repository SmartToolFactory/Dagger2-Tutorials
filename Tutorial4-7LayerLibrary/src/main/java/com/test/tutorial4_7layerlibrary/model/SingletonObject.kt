package com.test.tutorial4_7layerlibrary.model


import javax.inject.Inject
import javax.inject.Singleton

/**
 * * 🔥 Returns Singleton if it has same scope [ApplicationComponent] has.
 *
 * * 🔥 If un-scoped, NEW instance of [SingletonObject] is created
 * whenever an Activity/Fragment/Object is recreated.
 *
 * */
@Singleton
class SingletonObject @Inject constructor() {

    fun logSingletonObject() {
        println("SingletonObject logSingletonObject() $this")
    }
}