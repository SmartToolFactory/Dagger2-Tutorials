package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.domain.HomeUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) :ViewModel() {

    init {
        println("🚗 HomeViewModel init: ${this.hashCode()}")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "viewModel: ${this@HomeViewModel.hashCode()}, value: ${homeUseCase.getHomeItem()}"
    }
    val text: LiveData<String> = _text

    fun getHomeItem() {
        _text.value = "viewModel: ${this@HomeViewModel.hashCode()}, value: ${homeUseCase.getHomeItem()}"
    }
}