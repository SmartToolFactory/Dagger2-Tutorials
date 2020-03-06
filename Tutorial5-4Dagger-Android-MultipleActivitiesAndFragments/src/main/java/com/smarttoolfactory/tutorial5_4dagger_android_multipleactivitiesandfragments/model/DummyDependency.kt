package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.model

import android.content.Context
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.R

class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

}