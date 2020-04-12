package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SettingsViewModel @Inject constructor(): ViewModel() {

    init {
        println("🔧 SettingsViewModel init: ${this.hashCode()}")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is settings Fragment, viewModel: ${this@SettingsViewModel.hashCode()}"
    }
    val text: LiveData<String> = _text

}