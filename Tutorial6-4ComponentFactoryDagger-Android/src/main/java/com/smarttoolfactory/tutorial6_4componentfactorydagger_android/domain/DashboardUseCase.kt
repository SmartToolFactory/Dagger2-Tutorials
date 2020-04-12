package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.domain

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data.Repository
import javax.inject.Inject

class DashboardUseCase @Inject constructor(private val repository: Repository) {

    init {
        println("😛 DashboardUseCase init: ${this.hashCode()}")
    }

    fun getDashboardItem() = repository.getDashBoardItem()
}