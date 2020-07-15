package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model

import android.content.Context
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.R

class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

}