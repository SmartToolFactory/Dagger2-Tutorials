package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.MySharedPreferences
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.SensorController
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.SingletonObject
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.ToastMaker
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from ToastMakerModule @FragmentScope
    @Inject
    lateinit var toastMaker: ToastMaker

    // Injected from MySharedPreferencesModule @FragmentScope
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    // Injected via Constructor Injection NOT Singleton
    @Inject
    lateinit var sensorController: SensorController

    // 🔥 Injected via Constructor Injection with @Singleton scope
    @Inject
    lateinit var singletonObject: SingletonObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initInjection()

        toastMaker.showToast("SharedPreferences: $sharedPreferences")

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "@FragmentScope MySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "@FragmentScope ToastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor Un-scoped sensorController: ${sensorController.hashCode()}\n"+
                        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"

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