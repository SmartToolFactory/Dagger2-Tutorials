package com.example.tutorial5_2dagger_android_subcomponents3

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import com.example.tutorial5_2dagger_android_subcomponents2.model.ToastMaker
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Each Activity has it's own module. MainActivity has MainActivityModule, SecondActivity has
 * SecondActivityModule with @ActivityScope.
 *
 *
 *
 * Each object injected from module only lives through lifecycle of Activities.
 * When an Activity is rotated new ToastMaker object is created for both activities.
 */
class MainActivity : DaggerAppCompatActivity() {

    // Injected from AppModule with @Singleton
    @Inject
  lateinit  var sharedPreferences: SharedPreferences

    // Injected from MainActivity SubComponent Module with @ActivityScope
    @Inject
   lateinit var toastMaker: ToastMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("🎃 MainActivity toastMaker: $toastMaker")
        toastMaker.showToast("sharedPreferences $sharedPreferences")

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}