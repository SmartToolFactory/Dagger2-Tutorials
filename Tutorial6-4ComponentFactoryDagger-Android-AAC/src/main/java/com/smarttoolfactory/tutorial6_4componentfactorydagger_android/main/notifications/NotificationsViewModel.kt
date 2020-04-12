package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.domain.NotificationsUseCase
import javax.inject.Inject

class NotificationsViewModel @Inject constructor(private val notificationsUseCase: NotificationsUseCase) : ViewModel() {

    init {
        println("🥶 NotificationsViewModel init: ${this.hashCode()}")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "viewModel: ${this@NotificationsViewModel.hashCode()}, value: ${notificationsUseCase.getNotificationsItem()}"
    }
    val text: LiveData<String> = _text

    fun getNotificationItem() {
        _text.value = "viewModel: ${this@NotificationsViewModel.hashCode()}, value: ${notificationsUseCase.getNotificationsItem()}"
    }
}