package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.domain

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data.SettingsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsUseCase @Inject constructor(private val settingsRepository: SettingsRepository) {

    init {
        println("🤝 SettingsUseCase init: ${this.hashCode()}")
    }

    fun getSettingsItem() = settingsRepository.getSettingsItem()
}