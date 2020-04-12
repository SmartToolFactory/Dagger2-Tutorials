package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.model

import android.content.Context
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.R

class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

}