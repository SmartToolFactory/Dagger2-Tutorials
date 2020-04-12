package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data

import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor() : SettingsRepository {

    private var settingsCounter = 0

    init {
        println("💀 SettingsRepositoryImpl init: $this")
    }

    override fun getSettingsItem(): String {
        settingsCounter++
        return "Settings Item $settingsCounter"
    }

}