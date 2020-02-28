package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.ToastMaker
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

        val applicationComponent = (application as MyApplication).applicationComponent
        val toastMakerSubComponent = applicationComponent
                .toastMakerBuilder()
                .context(this)
                .build()
        toastMakerSubComponent.inject(this)
    }
}