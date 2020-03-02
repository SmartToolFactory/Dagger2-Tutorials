package com.example.tutorial5_2dagger_android_subcomponents

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import com.example.tutorial5_2dagger_android_subcomponents.model.ToastMaker
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from ToastMaker SubComponent Module
    @Inject
    lateinit var toastMaker: ToastMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastMaker.showToast("sharedPreferences $sharedPreferences")

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "@ActivityScope ToastMaker: ${toastMaker.hashCode()}"
    }
}