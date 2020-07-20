package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.main

import com.smarttoolfactory.tutorial9_2core.di.scope.FragmentScope
import dagger.Subcomponent


@FragmentScope
@Subcomponent
interface MainFragmentSubComponent {



    fun inject(mainFragment: MainFragment)

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainFragmentSubComponent
    }


}