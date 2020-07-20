package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.home

import android.app.Application
import android.content.Context
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.HomeFragmentObject
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [HomeFragmentBindModule::class])
class HomeFragmentModule {

    @Provides
    fun provideHomeFragmentObject(context: Context) = HomeFragmentObject(context)
}

@Module
abstract class HomeFragmentBindModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}