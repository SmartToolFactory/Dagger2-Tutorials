package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.main

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.SensorController
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.ToastMaker
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.second.SecondActivity
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * [FirstFragment] contains mySharedPreferences instance from MyFragmentModule
 * with @FragmentScope which is created each time [FirstFragment] is created.
 *
 * Also contains [ToastMaker] from [MainActivityModule] with @ActivityScope
 * which live as long as Activity is alive
 *
 * Scope and sub-component determines the lifecycle of an injected object
 */
class MainActivity : DaggerAppCompatActivity() {

    // Injected from AppModule with @Singleton
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    /**
     * Injected from [MainActivityModule] with @ActivityScope
     * which is the same object with MyFragment.
     */
    @Inject
    lateinit var toastMaker: ToastMaker

    // Constructor Injection
    @Inject
    lateinit var sensorController: SensorController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        toastMaker.showToast("MainActivity sharedPreferences $sharedPreferences")


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
                        "@ActivityScope toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor @ActivityScope sensorController: ${sensorController.hashCode()}"
    }

    private fun replaceFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, FirstFragment()).commit()
    }

}