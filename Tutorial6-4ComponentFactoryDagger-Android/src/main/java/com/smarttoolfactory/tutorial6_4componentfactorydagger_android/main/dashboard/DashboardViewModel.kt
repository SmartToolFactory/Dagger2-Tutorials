package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.domain.DashboardUseCase
import javax.inject.Inject

class DashboardViewModel @Inject constructor(private val dashboardUseCase: DashboardUseCase) : ViewModel() {

    init {
        println("😎 DashboardViewModel init: ${this.hashCode()}")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "viewModel: ${this@DashboardViewModel.hashCode()}, value: ${dashboardUseCase.getDashboardItem()}"
    }
    val text: LiveData<String> = _text

    fun getDashboardItem() {
        _text.value = "viewModel: ${this@DashboardViewModel.hashCode()}, value: ${dashboardUseCase.getDashboardItem()}"
    }
}