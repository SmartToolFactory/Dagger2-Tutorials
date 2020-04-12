package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() :ViewModel() {

    init {
        println("🚗 HomeViewModel init: ${this.hashCode()}")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment, viewModel: ${this@HomeViewModel.hashCode()}"
    }
    val text: LiveData<String> = _text
}