package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DashboardViewModel @Inject constructor(): ViewModel() {

    init {
        println("😎 DashboardViewModel init: ${this.hashCode()}")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment, viewModel: ${this@DashboardViewModel.hashCode()}"
    }
    val text: LiveData<String> = _text
}