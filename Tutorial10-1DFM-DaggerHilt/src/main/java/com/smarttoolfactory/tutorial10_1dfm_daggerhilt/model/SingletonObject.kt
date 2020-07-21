package com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SingletonObject @Inject constructor() {

    fun logSingletonObject() {
        println("SingletonObject logSingletonObject() $this")
    }
}