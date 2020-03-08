package com.smarttoolfactory.tutorial7_2bindsvsprovides2.model

import javax.inject.Inject

class SnackerImpl @Inject constructor() : Snacker {

    override fun createSnack() {
        println("SnackerImpl createSnack() $this")
    }

}