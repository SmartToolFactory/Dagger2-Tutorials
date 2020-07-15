package com.test.tutorial4_8layerlibrary

import dagger.android.support.DaggerApplication
import java.util.*

abstract class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    fun testResult(): Int {
        val random = Random()
        return random.nextInt(100)
    }

}