package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SingletonObject @Inject constructor() {

    fun logSingletonObject() {
        println("SingletonObject logSingletonObject() $this")
    }
}