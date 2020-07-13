package com.smarttoolfactory.tutorial8_1daggerhilt_basics.model

import javax.inject.Inject

class SimpleDependency @Inject constructor() {

    fun greet(name: String): String {
        return "My name is $name"
    }
}