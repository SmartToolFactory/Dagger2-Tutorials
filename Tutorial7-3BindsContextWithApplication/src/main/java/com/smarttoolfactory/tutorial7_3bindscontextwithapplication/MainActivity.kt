package com.smarttoolfactory.tutorial7_3bindscontextwithapplication

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial7_3bindscontextwithapplication.di.AppComponent
import com.smarttoolfactory.tutorial7_3bindscontextwithapplication.di.AppModule
import com.smarttoolfactory.tutorial7_3bindscontextwithapplication.model.SensorController
import javax.inject.Inject

/**
 * Tutorial that shows how to use @Binds annotation with Context
 * `@Binds abstract fun bindContext(application: Application): Context` in [AppModule]
 * to add context from [AppComponent] that was added to graph with @BindsInstance as parameter
 * in [AppComponent.Factory.create]
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var sensorController: SensorController

    override fun onCreate(savedInstanceState: Bundle?) {

        // Inject AppComponent into this Activity
        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "Constructor @ActivityScope sensorController: ${sensorController.hashCode()}"

    }
}