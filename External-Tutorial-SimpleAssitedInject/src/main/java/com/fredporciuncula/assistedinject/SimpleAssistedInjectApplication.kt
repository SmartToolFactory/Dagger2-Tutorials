package com.fredporciuncula.assistedinject

import android.app.Activity
import android.app.Application

class SimpleAssistedInjectApplication : Application() {

  val component: ApplicationComponent by lazy {
    DaggerApplicationComponent.builder()
      .applicationContext(applicationContext)
      .build()
  }
}

val Activity.component get() = (application as SimpleAssistedInjectApplication).component
