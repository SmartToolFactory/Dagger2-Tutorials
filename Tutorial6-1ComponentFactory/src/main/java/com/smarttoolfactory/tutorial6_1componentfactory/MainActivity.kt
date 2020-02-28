package com.smarttoolfactory.tutorial6_1componentfactory

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial6_1componentfactory.model.DefaultToastMaker
import com.smarttoolfactory.tutorial6_1componentfactory.model.MySharedPreferences
import com.smarttoolfactory.tutorial6_1factory.R
import javax.inject.Inject

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
        (application as MyApplication).appComponent.inject(this)

        mySharedPreferences.putData("data", 11)
        defaultToastMaker.showToast("defaultToastMaker: $defaultToastMaker," +
                " mySharedPreferences: $mySharedPreferences")
        findViewById<TextView>(R.id.tvInfo).text = "defaultToastMaker: $defaultToastMaker," +
                " mySharedPreferences: $mySharedPreferences"


    }
}
