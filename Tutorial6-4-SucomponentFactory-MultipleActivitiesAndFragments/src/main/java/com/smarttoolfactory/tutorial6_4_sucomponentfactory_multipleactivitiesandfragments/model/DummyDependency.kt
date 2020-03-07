package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model

import android.content.Context
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.R

class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

}