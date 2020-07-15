package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model

import android.app.Application
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.R

class DummyDependency(private val application: Application) {

    val applicationName: String
        get() = application.getString(R.string.app_name)

}