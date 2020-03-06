package com.example.tutorial5_2dagger_android_subcomponents3

import android.content.SharedPreferences
import android.os.Bundle
import com.example.tutorial5_2dagger_android_subcomponents2.model.ToastMaker
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SecondActivity : DaggerAppCompatActivity() {

    // Injected from AppModule with @Singleton
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from SecondActivity SubComponent Module with @ActivityScope
    @Inject
    lateinit var toastMaker: ToastMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("👀 SecondActivity toastMaker: $toastMaker")
        toastMaker.showToast("sharedPreferences $sharedPreferences")
    }
}