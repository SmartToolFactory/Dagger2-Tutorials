package com.smarttoolfactory.tutorial6_3subcomponentfactory

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.ToastMaker
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    // Injected from ApplicationModule
    @Inject
   lateinit var sharedPreferences: SharedPreferences

    // Injected from ToastMakerModule
    @Inject
    lateinit var toastMaker: ToastMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInjection()

        toastMaker.showToast("SharedPreferences: $sharedPreferences")
        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = "ToastMaker: $toastMaker\n sharedPreferences: $sharedPreferences"
    }

    private fun initInjection() {

        val appComponent = (application as MyApplication).appComponent


        // 🔥SubComponent Builder
//        val toastMakerSubComponent = appComponent
//                .toastMakerBuilder()
//                .context(this)
//                .build()

        // 🔥 SubComponent Factory
        val toastMakerSubComponent = appComponent
                .toastAndSharedPreferencesFactory
                .create(this)

        toastMakerSubComponent.inject(this)


    }
}