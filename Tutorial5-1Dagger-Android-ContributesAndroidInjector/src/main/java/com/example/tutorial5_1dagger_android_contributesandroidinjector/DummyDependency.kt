package com.example.tutorial5_1dagger_android_contributesandroidinjector

import android.content.Context

class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

    init {
        println("DummyDependency Context: $context")
    }
}