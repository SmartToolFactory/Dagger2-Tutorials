package com.example.tutorial3scope2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial3scope2.di.ApplicationModule
import com.example.tutorial3scope2.model.MySharedPreferences
import com.example.tutorial3scope2.model.SampleObject
import javax.inject.Inject
import javax.inject.Named

/**
 * This activity contains both constructor
 * and field injected [MySharedPreferences] objects.
 *
 * ApplicationModule_ProvideMySharedPreferencesFactory
 * class provide [MySharedPreferences] for field injection
 *
 * MySharedPreferences_Factory in model package
 * provides [MySharedPreferences] instance for constructor injection.
 *
 */
class MainActivity : AppCompatActivity() {

    /**
     * 🔥 This object has a scope in [ApplicationModule]
     * thus it's a SINGLETON object
     */
    @Named("Field")
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    /**
     * 🔥 This constructor injected object has no scope thus
     * it's NOT a SINGLETON object
     */
    @Inject
    lateinit var mySharedPreferencesConstructor: MySharedPreferences

    /**
     *  🔥 Injected from [ApplicationModule] with no scope which creates new instance
     *  of this object every time this Activity is created
     */
    @Inject
    lateinit var sampleObject: SampleObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as MyApplication).applicationComponent.inject(this)

        println("Field Injected @Singleton myShared: $mySharedPreferences")
        println("Constructor Injected No Scope myShared: $mySharedPreferencesConstructor")

        findViewById<TextView>(R.id.tvInfo).text =
                "Field Injected @Singleton myShared: ${mySharedPreferences.hashCode()}\n" +
                        "Constructor injected  No Scope myShared: ${mySharedPreferencesConstructor.hashCode()}\n" +
                        "AppModule with No scope sampleObject: ${sampleObject.hashCode()}"
    }
}