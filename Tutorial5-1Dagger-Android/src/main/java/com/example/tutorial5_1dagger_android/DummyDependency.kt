package com.example.tutorial5_1dagger_android

import android.content.Context

/**
 * Context of this class comes from
 * @Binds
 * public abstract Context bindContext(Application application);
 * which is in [com.example.tutorial5_1dagger_android.di.AppModule]
 */
class DummyDependency(private val context: Context) {

    val applicationName: String
        get() = context.getString(R.string.app_name)

}