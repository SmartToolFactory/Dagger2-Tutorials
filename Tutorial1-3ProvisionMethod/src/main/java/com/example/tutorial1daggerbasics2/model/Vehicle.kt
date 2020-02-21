package com.example.tutorial1daggerbasics2.model

class Vehicle(private val motor: Motor) {

    fun increaseSpeed(value: Int) {
        motor.accelerate(value)
    }

    fun stop() {
        motor.brake()
    }

    val speed: Int
        get() = motor.rpm

}