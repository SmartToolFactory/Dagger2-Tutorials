package com.test.tutorial4_7layerlibrary.model


import com.test.tutorial4_7layerlibrary.di.ActivityScope
import javax.inject.Inject


@ActivityScope
class ActivityScopedObject @Inject constructor() {

    fun logActivityScopedObject() {
        println("ActivityScopedObject logActivityScopedObject() $this")
    }
}