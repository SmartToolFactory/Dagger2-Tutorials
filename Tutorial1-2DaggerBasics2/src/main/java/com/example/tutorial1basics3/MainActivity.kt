package com.example.tutorial1basics3

import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial1basics3.model.SensorController
import com.example.tutorial1basics3.model.User
import javax.inject.Inject

/**
 * This tutorial displays that objects created with @Singleton or any scope in Application module
 * are singleton and not re-created when an Activity is recreated.
 */
class MainActivity : AppCompatActivity(), SensorController.OnSensorEventChangeListener {

    // Inject field Application from Module with provideMyApplication
    @Inject
    lateinit var myApplication: MyApplication

    // Inject field User from Module with provideUser
    // This is a Singleton object because it has @Singleton on app level module
    // @Singleton does not mean object will be singleton, it's singleton if it's used on application level modules
    @Inject
    lateinit var user: User

    // Inject field SensorController from Module with provideSensorController
    // This object is not a Singleton
    @Inject
    lateinit var sensorController: SensorController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).appContextComponent.inject(this)

        sensorController.setSensorEventChangeListener(this)

        println("SensorController: $sensorController")
        println("User: $user")
    }

    override fun onResume() {
        super.onResume()
        sensorController!!.onResume(SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        super.onPause()
        sensorController!!.onPause()
    }

    override fun getOrientationValues(azimuth: Float, pitch: Float, roll: Float) {
        val textView = findViewById<TextView>(R.id.result)
        textView.text = "Azimuth: $azimuth, float: $pitch, roll: $roll"
    }
}