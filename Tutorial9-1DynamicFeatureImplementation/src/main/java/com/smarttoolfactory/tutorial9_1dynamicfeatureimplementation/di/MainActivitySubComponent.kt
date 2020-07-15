package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di

import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.MainActivity
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di.scope.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [
    MainActivityModule::class])
interface MainActivitySubComponent {

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivitySubComponent
    }

    fun inject(mainActivity: MainActivity)

}