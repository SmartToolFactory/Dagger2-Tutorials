package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.DashboardFragmentModule
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.HomeFragmentModule
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.NotificationsFragmentModule
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.scope.FragmentScope
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.dashboard.DashboardFragment
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.home.HomeFragment
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.notifications.NotificationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * [MainActivityFragmentContributorModule] is used inside [ActivityContributorModule]
 * With @ContributesAndroidInjector(modules = FragmentContributorModule.class)
 * defines which module will be used to inject objects to declared fragments
 */
@Module
abstract class MainActivityFragmentContributorModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DashboardFragmentModule::class])
    abstract fun contributeDashboardFragment(): DashboardFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [NotificationsFragmentModule::class])
    abstract fun contributeNotificationsFragment(): NotificationsFragment
}
