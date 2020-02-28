package com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.model.DefaultToastMaker
import com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.model.MySharedPreferences
import javax.inject.Inject

/**
 * This tutorial shows difference between builder and factory for component interface.
 *
 * Component.Factory has one method where it binds arguments passed to this method
 * Component.Builder can have multiple methods
 */
class MainActivity : AppCompatActivity() {

    // Injected from AppModule
    @Inject
    lateinit var defaultToastMaker: DefaultToastMaker

    // Injected via Constructor Injection
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set this Activity as MemberInjector
        initInjections()

        mySharedPreferences.putData("data", 11)
        defaultToastMaker.showToast("defaultToastMaker: $defaultToastMaker," +
                " mySharedPreferences: $mySharedPreferences")
        findViewById<TextView>(R.id.tvInfo).text = "defaultToastMaker: $defaultToastMaker," +
                " mySharedPreferences: $mySharedPreferences"


    }

    private fun initInjections() {
        
        // 🔥 Not only one Component can be injected to an object, MainActivity here

        // Injection using AppComponent with Factory
//        (application as MyApplication).appComponentWithFactory.inject(this)

        // Injection using AppComponent with Factory
        (application as MyApplication).appComponentWithBuilder.inject(this)
    }
}
