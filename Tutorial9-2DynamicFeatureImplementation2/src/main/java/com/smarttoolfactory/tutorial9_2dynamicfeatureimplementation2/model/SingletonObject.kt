package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model

import javax.inject.Inject
import javax.inject.Singleton


/**
 * 🔥🔥 Cannot inject this object to
 * any DEPENDENT module(MainActivityModule, dynamic feature CameraModule, etc)
 * since it has different scope which is @Singleton
 */
@Singleton
class SingletonObject @Inject constructor() {

    fun logSingletonObject() {
        println("SingletonObject logSingletonObject() $this")
    }
}