package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model

import android.content.Context
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.R

class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

}