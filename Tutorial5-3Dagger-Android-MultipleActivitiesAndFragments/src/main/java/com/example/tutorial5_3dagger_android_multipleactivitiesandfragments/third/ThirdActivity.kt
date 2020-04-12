package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.third

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.ActivityContributorModule
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.SingletonObject
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Must be added to [ActivityContributorModule] to not have
 * ERROR java.lang.IllegalArgumentException: No injector factory bound for Class<com.example
 */
class ThirdActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    // Injected from AppModule with @Singleton
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // 🔥 Injected via Constructor Injection with @Singleton scope
    @Inject
    lateinit var singletonObject: SingletonObject


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}