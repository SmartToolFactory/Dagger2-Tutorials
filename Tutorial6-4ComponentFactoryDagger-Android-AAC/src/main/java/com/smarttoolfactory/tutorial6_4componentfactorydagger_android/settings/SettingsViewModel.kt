package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.domain.SettingsUseCase
import javax.inject.Inject

class SettingsViewModel @Inject constructor(private val settingsUseCase: SettingsUseCase) : ViewModel() {

    init {
        println("🔧 SettingsViewModel init: ${this.hashCode()}")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "viewModel: ${this@SettingsViewModel.hashCode()}, ${settingsUseCase.getSettingsItem()}"
    }
    val text: LiveData<String> = _text

    fun getSettingsItem() {
        _text.value = "viewModel: ${this@SettingsViewModel.hashCode()}, ${settingsUseCase.getSettingsItem()}"
    }
}