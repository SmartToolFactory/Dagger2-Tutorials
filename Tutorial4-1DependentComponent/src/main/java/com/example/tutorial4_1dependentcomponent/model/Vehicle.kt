package com.example.tutorial4_1dependentcomponent.model

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