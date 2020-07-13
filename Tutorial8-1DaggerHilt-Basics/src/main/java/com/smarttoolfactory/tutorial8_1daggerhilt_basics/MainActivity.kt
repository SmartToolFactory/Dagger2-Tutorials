package com.smarttoolfactory.tutorial8_1daggerhilt_basics

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial8_1daggerhilt_basics.model.SimpleDependency
import com.smarttoolfactory.tutorial8_1daggerhilt_basics.model.ToastMaker
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var simpleDependency: SimpleDependency

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var toastMaker: ToastMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvInfo = findViewById<TextView>(R.id.tvInfo)

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "ApplicationModule ToastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor dependency simpleDependency: ${simpleDependency.hashCode()}"

        toastMaker.showToast("Injected from AppModule")
    }
}