package com.smarttoolfactory.tutorial7_3bindscontextwithapplication.model

import android.content.Context
import com.smarttoolfactory.tutorial7_3bindscontextwithapplication.R

class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

}