package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di


import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.main.MainFragmentSubComponent
import dagger.Module

@Module(
        subcomponents = [
            MainFragmentSubComponent::class
        ]
)
class FragmentSubComponentsModule