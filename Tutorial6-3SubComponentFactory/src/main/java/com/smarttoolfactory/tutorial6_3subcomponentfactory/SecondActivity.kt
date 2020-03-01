package com.smarttoolfactory.tutorial6_3subcomponentfactory

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.MySharedPreferences
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.SensorController
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.SingletonObject
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.ToastMaker
import javax.inject.Inject

/**
 * ToastMakerModule and MySharedPreferencesModule are scoped with @FragmentScope
 */
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

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "@FragmentScope MySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "@FragmentScope ToastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor Un-scoped sensorController: ${sensorController.hashCode()}\n"+
                        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"

        toastMaker.showToast("SharedPreferences: $sharedPreferences")

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