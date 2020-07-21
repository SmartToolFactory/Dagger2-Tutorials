package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model

import android.content.Context

/**
 * To inject this there should be @Binds that gets Context from an Application
 */
class MainActivityObject(private val context: Context)