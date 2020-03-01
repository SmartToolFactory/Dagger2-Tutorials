package com.example.tutorial1daggerbasics2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial1daggerbasics2.di.DaggerVehicleComponent
import com.example.tutorial1daggerbasics2.di.VehicleComponent
import com.example.tutorial1daggerbasics2.di.VehicleModule
import com.example.tutorial1daggerbasics2.model.Vehicle

/**
 * This tutorial displays that provision method in [VehicleComponent] returns [Vehicle].
 *
 * Note: Returned object is not singleton since it's created inside this Activity.
 *
 * Provision method does the same thing with
 * @Inject lateinit var vehicle: Vehicle
 */
class MainActivity : AppCompatActivity() {

    private lateinit var vehicle: Vehicle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component: VehicleComponent = DaggerVehicleComponent.builder().vehicleModule(VehicleModule()).build()

        vehicle = component.provideVehicle()

        findViewById<TextView>(R.id.tvInfo).text = "Vehicle $vehicle"

    }
}