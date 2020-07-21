package com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model

import android.content.Context

/**
 * To inject this there should be @Binds that gets Context from an Application
 */
class MainActivityObject(private val context: Context)