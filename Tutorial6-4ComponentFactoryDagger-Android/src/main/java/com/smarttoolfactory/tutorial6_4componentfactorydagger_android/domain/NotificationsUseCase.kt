package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.domain

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data.Repository
import javax.inject.Inject

class NotificationsUseCase @Inject constructor(private val repository: Repository) {

    init {
        println("😍 NotificationsUseCase init: ${this.hashCode()}")
    }

    fun getNotificationsItem() = repository.getNotificationsItem()
}