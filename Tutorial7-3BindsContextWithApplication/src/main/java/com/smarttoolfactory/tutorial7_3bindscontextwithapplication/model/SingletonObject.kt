package com.smarttoolfactory.tutorial7_3bindscontextwithapplication.model

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SingletonObject @Inject constructor() {

    fun logSingletonObject() {
        println("SingletonObject logSingletonObject() $this")
    }
}