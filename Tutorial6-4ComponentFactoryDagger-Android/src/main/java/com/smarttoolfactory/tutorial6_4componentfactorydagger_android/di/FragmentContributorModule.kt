package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di

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
    @ContributesAndroidInjector
    abstract fun contributeRepoDetailFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment(): DashboardFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeNotificationsFragment(): NotificationsFragment
}
