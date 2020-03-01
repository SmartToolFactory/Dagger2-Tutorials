package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di

import android.app.Application
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*
 * Differences between AppComponent of dagger-android and regular dagger:
 *
  * 1- Binds AndroidSupportInjectionModule.class in modules
 *  2- Extends AndroidInjector<MyApplication>
 *  3- Does not have sub-component builder to inject to classes inside sub-component
 *  DummyDependencyComponent.Builder dummyDependencyBuilder(); is not required in app component
 */

/*
 * Differences between AppComponent of dagger-android and regular dagger:
 *
  * 1- Binds AndroidSupportInjectionModule.class in modules
 *  2- Extends AndroidInjector<MyApplication>
 *  3- Does not have sub-component builder to inject to classes inside sub-component
 *  DummyDependencyComponent.Builder dummyDependencyBuilder(); is not required in app component
 */
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityContributorModule::class])
/*
 * ActivityContributorModule defines which Activities will have which modules and inject objects
 * If an Activity has any fragments it should add them via FragmentContributorModule with @ContributesAndroidInjector
 * @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentContributorModule.class})
 */
@Singleton
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application?): Builder

        fun build(): AppComponent
    }

    override fun inject(myApplication: MyApplication)
}