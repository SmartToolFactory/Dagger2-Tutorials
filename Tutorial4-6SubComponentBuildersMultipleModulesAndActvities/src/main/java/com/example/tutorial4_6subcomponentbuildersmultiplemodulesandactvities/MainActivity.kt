package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities

import android.content.Intent
import android.content.SharedPreferences
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.DummyDependency
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.SensorController
import javax.inject.Inject

/*
 ONLY one component can inject to an Object
 */
class MainActivity : AppCompatActivity() {

    // Injected from ApplicationModule
    @Inject
   lateinit var sharedPreferences: SharedPreferences

    // Injected from DummyDependencyModule
    @Inject
    lateinit var dummyDependency: DummyDependency

    // Constructor Injection
    @Inject
    lateinit var sensorController: SensorController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInjection()

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.text_view).text = "Dummy:  ${dummyDependency.applicationName}"

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, MyFragment()).commit()

        println("MainActivity sharedPreferences: $sharedPreferences")
        Toast.makeText(this, "MainActivity: $sharedPreferences", Toast.LENGTH_SHORT).show()
    }

    private fun initInjection() {
        val applicationComponent = (application as MyApplication).applicationComponent

        // Dummy Dependency
        val dummyDependencyComponent = applicationComponent
                .dummyDependencyBuilder()
                .context(this)
                .build()

        dummyDependencyComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        sensorController.onResume(SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        super.onPause()
        sensorController.onPause()
    }
}