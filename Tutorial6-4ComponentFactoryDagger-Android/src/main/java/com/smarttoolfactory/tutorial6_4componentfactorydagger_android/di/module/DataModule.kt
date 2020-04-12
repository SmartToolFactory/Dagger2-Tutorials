package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data.Repository
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data.RepositoryImpl
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data.SettingsRepository
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [DataProviderModule::class])
interface DataModule {

    @Singleton
    @Binds
    fun bindRepository(repositoryImpl: RepositoryImpl): Repository


    @Binds
    fun bindSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl): SettingsRepository
}

@Module
object DataProviderModule {

}