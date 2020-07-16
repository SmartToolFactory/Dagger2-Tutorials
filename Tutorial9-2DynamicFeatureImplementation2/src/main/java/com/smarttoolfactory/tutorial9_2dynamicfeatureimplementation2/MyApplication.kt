package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2

import android.app.Activity
import android.app.Application
import android.content.Context
import com.smarttoolfactory.tutorial9_2core.di.CoreComponent
import com.smarttoolfactory.tutorial9_2core.di.DaggerCoreComponent

open class MyApplication : Application() {

    /**
     * Instance of the CoreComponent that will be used by all other components
     * that depend on CoreComponent in the project
     */
    val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }


    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
                (context.applicationContext as MyApplication).coreComponent
    }
}

fun Activity.coreComponent() = MyApplication.coreComponent(this)


