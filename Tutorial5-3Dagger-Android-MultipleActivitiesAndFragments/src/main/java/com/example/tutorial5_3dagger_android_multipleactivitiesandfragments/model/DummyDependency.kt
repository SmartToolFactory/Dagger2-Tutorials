package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model

import android.content.Context
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R

class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

}