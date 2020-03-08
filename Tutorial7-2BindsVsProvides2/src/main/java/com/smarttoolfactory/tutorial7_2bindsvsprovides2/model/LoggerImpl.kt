package com.smarttoolfactory.tutorial7_2bindsvsprovides2.model

import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {

    override fun log() {
        println("Logger $this")
    }


}