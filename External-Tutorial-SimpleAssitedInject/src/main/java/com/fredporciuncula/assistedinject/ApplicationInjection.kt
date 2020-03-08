package com.fredporciuncula.assistedinject

import android.content.Context
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AssistedInjectModule::class])
interface ApplicationComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance fun applicationContext(applicationContext: Context): Builder
    fun build(): ApplicationComponent
  }

  val textPresenterFactory: TextPresenter.Factory
}

@AssistedModule
@Module(includes = [AssistedInject_AssistedInjectModule::class])
interface AssistedInjectModule

// in a regular app we could've simply annotated an existing module instead of creating a new one
