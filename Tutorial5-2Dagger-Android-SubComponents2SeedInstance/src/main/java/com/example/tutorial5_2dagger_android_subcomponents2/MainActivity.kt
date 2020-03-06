package com.example.tutorial5_2dagger_android_subcomponents2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tutorial5_2dagger_android_subcomponents2.di.ToastMakerSubComponent
import com.example.tutorial5_2dagger_android_subcomponents2.model.ToastMaker
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * This tutorial shows how to use @Binds with seedInstance method in [ToastMakerSubComponent]
 * class to get context from a MainActivity in this example
 */
class MainActivity : DaggerAppCompatActivity() {
    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    // Injected from ToastMaker SubComponent
    @Inject
    lateinit var toastMaker: ToastMaker


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastMaker.showToast("sharedPreferences $sharedPreferences")

        findViewById<TextView>(R.id.tvInfo).text = "sharedPreferences: sharedPreferences\n" +
                "toastMaker: $toastMaker"


        findViewById<Button>(R.id.button).setOnClickListener {

            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)

        }
    }
}