package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data

interface Repository {

    fun getDashBoardItem(): String

    fun getHomeItem(): String

    fun getNotificationsItem(): String

}