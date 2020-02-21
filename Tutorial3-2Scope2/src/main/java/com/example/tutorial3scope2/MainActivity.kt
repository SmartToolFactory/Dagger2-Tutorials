package com.example.tutorial3scope2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial3scope2.model.MySharedPreferences
import javax.inject.Inject
import javax.inject.Named

/**
 * This activity contains both constructor and field injected [MySharedPreferences] objects.
 *
 * SharedPreferencesModule_ProvideMySharedPreferencesFactory class provide [MySharedPreferences] for field injection
 *
 * MySharedPreferences_Factory in model package provides [MySharedPreferences] instance for constructor injection
 */
class MainActivity : AppCompatActivity() {

    @Named("Field")
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    @Inject
    lateinit var mySharedPreferencesConstructor: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as MyApplication).myComponent.inject(this)

        println("Field Injected: $mySharedPreferences")
        println("Constructor Injected: $mySharedPreferencesConstructor")
    }
}