package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data

import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {

    private var dashboardCounter = 0
    private var homeCounter = 0
    private var notificationsCounter = 0

    init {
        println("👻 RepositoryImpl init: $this")
    }

    override fun getDashBoardItem(): String {
        dashboardCounter++
      return "Dashboard Item $dashboardCounter"
    }

    override fun getHomeItem(): String {
        homeCounter++
        return "Home Item $homeCounter"
    }

    override fun getNotificationsItem(): String {
        notificationsCounter++
       return  "Notifications Item $notificationsCounter"
    }

}