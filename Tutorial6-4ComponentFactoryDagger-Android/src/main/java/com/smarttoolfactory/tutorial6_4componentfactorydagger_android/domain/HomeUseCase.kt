package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.domain

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data.Repository
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val repository: Repository) {

    init {
        println("⏱ HomeUseCase init: ${this.hashCode()}")
    }

    fun getHomeItem() = repository.getHomeItem()
}