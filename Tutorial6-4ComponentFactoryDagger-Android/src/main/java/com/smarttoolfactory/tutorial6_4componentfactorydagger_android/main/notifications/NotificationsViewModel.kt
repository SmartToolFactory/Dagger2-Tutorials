package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class NotificationsViewModel @Inject constructor() : ViewModel() {

    init {
        println("🥶 NotificationsViewModel init: ${this.hashCode()}")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment, viewModel: ${this@NotificationsViewModel.hashCode()}"
    }
    val text: LiveData<String> = _text
}