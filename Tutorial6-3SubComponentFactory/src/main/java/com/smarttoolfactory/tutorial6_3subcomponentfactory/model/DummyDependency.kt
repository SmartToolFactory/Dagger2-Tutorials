package com.smarttoolfactory.tutorial6_3subcomponentfactory.model

import android.content.Context
import com.smarttoolfactory.tutorial6_3subcomponentfactory.R

class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

}