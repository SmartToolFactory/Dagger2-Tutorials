package com.test.tutorial4_7layerlibrary

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.test.tutorial4_7layerlibrary.di.BaseAppModule
import com.test.tutorial4_7layerlibrary.di.LibraryActivityModule
import com.test.tutorial4_7layerlibrary.model.*
import javax.inject.Inject

class LibraryActivity : AppCompatActivity() {

    /**
     *  Injected from [BaseAppModule] @Singleton
     */
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /**
     * Injected from [BaseAppModule] @Singleton
     */
    @Inject
    lateinit var toastMaker: ToastMaker


    /**
     * 🔥🔥🔥 Injected from [BaseAppModule] with NO SCOPE
     */
    @Inject
    lateinit var libraryObject: LibraryObject

    /**
     * Injected from [LibraryActivityModule] with @ActivityScope
     */
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences


    /**
     * Injected via Constructor Injection NO Scope
     */
    @Inject
    lateinit var sensorController: SensorController

    /**
     * Injected via Constructor Injection with @Singleton scope
     */
    @Inject
    lateinit var singletonObject: SingletonObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        initInjection()

        toastMaker.showToast("SharedPreferences: $sharedPreferences")

        findViewById<TextView>(R.id.tvInfo).text =
                "BaseAppModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "BaseAppModule ToastMaker: ${toastMaker.hashCode()}\n" +
                        "🔥 BaseAppModule LibraryModuleObject: ${libraryObject.hashCode()}\n" +
                        "LibraryActivityModule @ActivityScope mySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "Constructor Un-scoped sensorController: ${sensorController.hashCode()}\n" +
                        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"

    }

    private fun initInjection() {

        val applicationComponent = (application as BaseApplication).baseAppComponent
        val toastMakerSubComponent = applicationComponent
                .librarySubComponentBuilder()
                .context(this)
                .build()
        toastMakerSubComponent.inject(this)
    }
}