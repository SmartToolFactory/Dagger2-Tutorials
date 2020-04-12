package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {

    init {
        println("🚙 MainViewModel init: ${this.hashCode()}")

    }
}