package com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.model.DummyDependency
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.model.SensorController
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.model.SingletonObject
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.R
import javax.inject.Inject

/*
 ONLY one component can inject to an Object
 */
class MainActivity : AppCompatActivity() {

    // Injected from ApplicationModule
    @Inject
   lateinit var sharedPreferences: SharedPreferences

    // Injected from @ActivityScope DummyDependencyModule
    @Inject
    lateinit var dummyDependency: DummyDependency

    // Constructor Injection
    @Inject
    lateinit var sensorController: SensorController

    // 🔥 Injected via Constructor Injection with @Singleton scope
    @Inject
    lateinit var singletonObject: SingletonObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInjection()

        bindViews()

    }

    private fun bindViews() {
        findViewById<Button>(R.id.btn_second_activity).setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_frag).setOnClickListener {
            replaceFragment()
        }
        replaceFragment()

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "@ActivityScope dummyDependency: ${dummyDependency.hashCode()}\n" +
                        "Constructor @ActivityScope sensorController: ${sensorController.hashCode()}\n" +
                        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"
    }

    private fun replaceFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, FirstFragment()).commit()
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

}