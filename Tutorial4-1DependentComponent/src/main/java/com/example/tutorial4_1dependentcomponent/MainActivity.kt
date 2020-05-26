package com.example.tutorial4_1dependentcomponent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial4_1dependentcomponent.di.*
import com.example.tutorial4_1dependentcomponent.model.Vehicle
import javax.inject.Inject

/**
 *
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mVehicle: Vehicle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🔥 MotorComponent is dependency of VehicleComponent
        val motorComponent: MotorComponent = DaggerMotorComponent
                .builder()
                .motorModule(MotorModule())
                .build()

        val vehicleComponent: VehicleComponent = DaggerVehicleComponent
                .builder()
                // 🔥 Even though VehicleComponent does not have this method,
                //  it must be added  to VehicleComponent builder
                .motorComponent(motorComponent)
                .vehicleModule(VehicleModule())
                .build()
        vehicleComponent.inject(this)

        val textView = findViewById<TextView>(R.id.text_view)
        mVehicle.increaseSpeed(30)

        textView.text = "Vecihle speed:" + mVehicle.speed
    }
}