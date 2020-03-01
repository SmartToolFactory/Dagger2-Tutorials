package com.example.tutorial5_1dagger_android_contributesandroidinjector

import android.os.Bundle
import android.widget.TextView
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var dummyDependency: DummyDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            findViewById<TextView>(R.id.textView).text = "dummyDependency = $dummyDependency"
    }
}