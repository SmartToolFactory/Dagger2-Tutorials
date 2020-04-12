package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model

import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.AppComponent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * * 🔥 Returns Singleton if it has same scope [AppComponent] has.
 *
 * * 🔥 If un-scoped NEW instance of [SingletonObject] is created
 * whenever an Activity/Fragment/Object is recreated.
 *
 */
@Singleton
class SingletonObject @Inject constructor() {

    fun logSingletonObject() {
        println("SingletonObject logSingletonObject() $this")
    }
}