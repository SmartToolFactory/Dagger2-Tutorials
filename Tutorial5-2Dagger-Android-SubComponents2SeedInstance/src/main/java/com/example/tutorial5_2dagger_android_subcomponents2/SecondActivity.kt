package com.example.tutorial5_2dagger_android_subcomponents2

import android.os.Bundle
import android.widget.TextView
import com.example.tutorial5_2dagger_android_subcomponents2.model.LiveObject
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SecondActivity : DaggerAppCompatActivity() {

    // Injected from LiveObject SubComponent
    @Inject
    lateinit var liveObject: LiveObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<TextView>(R.id.tvInfo).text = "liveObject: $liveObject"
    }

}