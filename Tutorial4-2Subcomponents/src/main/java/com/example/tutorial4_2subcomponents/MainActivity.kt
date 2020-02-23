package com.example.tutorial4_2subcomponents

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial4_2subcomponents.di.ActivityModule
import com.example.tutorial4_2subcomponents.model.MySharedPreferences
import com.example.tutorial4_2subcomponents.model.ToastMaker
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    // Injected via Constructor injection, without @Singleton, it injects new instance after rotation
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences
    // Injected from ActivityModule
    @Inject
    lateinit var toastMaker: ToastMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication)
                .applicationComponent
                .newActivitySubComponent(ActivityModule(this))
                .inject(this)

        toastMaker.showToast("Hello World")
        mySharedPreferences.putData("data", 10)

        // Only SharedPreferences object with @Singleton is the same each time after rotation
        println("🚗 MainActivity ToastMaker: $toastMaker\n" +
                ", mMySharedPreferences: $mySharedPreferences\n" +
                ", mSharedPreferences: $sharedPreferences")
        val data = mySharedPreferences.getData("data")
        Toast.makeText(this, "Data: $data", Toast.LENGTH_SHORT).show()


        findViewById<TextView>(R.id.tvInfo).text = "ToastMaker: $toastMaker\n" +
                ", mMySharedPreferences: $mySharedPreferences\n" +
                ", mSharedPreferences: $sharedPreferences"
    }
}