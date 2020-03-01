package com.example.tutorial4_5subcomponentbuilders

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial4_5subcomponentbuilders.model.SingletonObject
import com.example.tutorial4_5subcomponentbuilders.model.ToastMaker
import javax.inject.Inject

/**
 * This tutorial displays that scoped objects that are in Components are re-created
 * whenever an Activity, Fragment or object is recreated.
 *
 * * 🔥If an object has scope on it's Constructor that matches ApplicationComponent's
 * scope then it's declared as Singleton
 */
class MainActivity : AppCompatActivity() {

    // Injected from ApplicationModule, and this is a Singleton object
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from ToastMaker SubComponent Module,
    // and new instance is created every time device is rotated
    @Inject
    lateinit var toastMaker: ToastMaker

    @Inject
    lateinit var singletonObject: SingletonObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applicationComponent = (application as MyApplication).applicationComponent
        val toastMakerSubComponent = applicationComponent
                .toastMakerBuilder()
                .context(this)
                .build()

        toastMakerSubComponent.inject(this)

        toastMaker.showToast("sharedPreferences $sharedPreferences")

        println("ToastMaker: $toastMaker, sharedPreferences: $sharedPreferences")

        findViewById<TextView>(R.id.tvInfo).text =
                " AppModule sharedPreferences: ${sharedPreferences.hashCode()} \n" +
                        "@ActivityScope ToastMakerModule ToastMaker: ${toastMaker.hashCode()}\n" +
                        "@Singleton scope Constructor Injection SingletonObject: ${singletonObject.hashCode()}"

    }
}