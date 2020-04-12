package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.second

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.ToastMaker
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SecondActivity : DaggerAppCompatActivity() {

    // Injected from AppModule with @Singleton
    @Inject
   lateinit var sharedPreferences: SharedPreferences

    // Injected from SecondActivityModule with @ActivityScope
    @Inject
    lateinit var toastMaker: ToastMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        println("🚙 SecondActivity toastMaker: $toastMaker")
        println("🚙 SecondActivity sharedPreferences: $sharedPreferences")
        toastMaker.showToast("SecondActivity SharedPreferences: $sharedPreferences")
        val textView = findViewById<TextView>(R.id.tvInfo)
        textView.text = "ToastMaker: $toastMaker\n sharedPreferences: $sharedPreferences"
    }
}