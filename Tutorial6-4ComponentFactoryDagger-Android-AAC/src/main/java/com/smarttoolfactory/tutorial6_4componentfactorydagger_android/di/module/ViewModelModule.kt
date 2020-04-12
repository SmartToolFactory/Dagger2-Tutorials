package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.key.ViewModelKey
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.MainViewModel
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.dashboard.DashboardViewModel
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.home.HomeViewModel
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.notifications.NotificationsViewModel
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.settings.SettingsViewModel
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.viewmodel.CustomViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *
 * This module is used for retrieving ViewModels using [CustomViewModelFactory], viewModels are put into map
 * via @IntoMap and @ViewModelKey annotations
 *
 * IntoMap creates a key-value pair to get relevant ViewModel. Key is the class name of ViewModel
 * and value is the ViewModel itself
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel::class)
    abstract fun bindNotificationsViewModel(notificationsViewModel: NotificationsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsViewModel(settingsViewModel: SettingsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: CustomViewModelFactory): ViewModelProvider.Factory
}
