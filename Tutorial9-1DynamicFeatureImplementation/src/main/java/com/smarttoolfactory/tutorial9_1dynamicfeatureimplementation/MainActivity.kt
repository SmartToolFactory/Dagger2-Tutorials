package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di.MainActivitySubComponent
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.MainActivityDependency
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.SensorController
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.ToastMaker
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivitySubComponent

    /**
     * Injected from [AppModule] with @Singleton scope
     */
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /**
     * Injected from [AppModule] with no scope
     */
    @Inject
    lateinit var toastMaker: ToastMaker

    /**
     * Injected via constructor injection with no scope
     */
    @Inject
    lateinit var sensorController: SensorController

    /**
     * Injected from [MainActivityModule] with @ActivityScope
     */
    @Inject
    lateinit var mainActivityDependency: MainActivityDependency


    override fun onCreate(savedInstanceState: Bundle?) {


        initInjection()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvInfo).text =
                "AppModule @Singleton sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                "AppModule no scope toastMaker: ${toastMaker.hashCode()}\n" +
                "MainActivityModule @ActivityScope mainActivityDependency: ${mainActivityDependency.hashCode()}\n" +
                        "Constructor no scope sensorController: ${sensorController.hashCode()}"

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