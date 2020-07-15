package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di.MainActivitySubComponent
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.SensorController
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivitySubComponent

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var sensorController: SensorController

    override fun onCreate(savedInstanceState: Bundle?) {

//        (application as MyApplication).appComponent.inject(this)

        initInjection()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "Constructor @ActivityScope sensorController: ${sensorController.hashCode()}"

        val btnGallery = findViewById<Button>(R.id.btnGalleryActivity)

        btnGallery.setOnClickListener {
            val intent = Intent()
                    .setClassName(this, "com.smarttoolfactory.gallery.GalleryActivity")
            startActivity(intent)
        }

    }

    private fun initInjection() {

        val appComponent = (application as MyApplication).appComponent

        mainActivityComponent = appComponent
                .mainActivityComponentFactory()
                .create()

        mainActivityComponent.inject(this)
    }
}