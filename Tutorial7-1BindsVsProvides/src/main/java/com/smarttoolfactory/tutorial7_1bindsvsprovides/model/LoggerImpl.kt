package com.smarttoolfactory.tutorial7_1bindsvsprovides.model

import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {

    override fun log() {
        println("Logger $this")
    }


}