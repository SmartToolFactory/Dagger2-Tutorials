package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.DashboardFragmentModule
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.HomeFragmentModule
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.NotificationsFragmentModule
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.scope.FragmentScope
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.ui.dashboard.DashboardFragment
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.ui.home.HomeFragment
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.ui.notifications.NotificationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * [FragmentContributorModule] is used inside [ActivityContributorModule]
 * With @ContributesAndroidInjector(modules = FragmentContributorModule.class)
 * defines which module will be used to inject objects to declared fragments
 */
@Module
abstract class FragmentContributorModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun contributeHomeFragmentFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DashboardFragmentModule::class])
    abstract fun contributeDashboardFragment(): DashboardFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [NotificationsFragmentModule::class])
    abstract fun contributeNotificationsFragment(): NotificationsFragment
}
