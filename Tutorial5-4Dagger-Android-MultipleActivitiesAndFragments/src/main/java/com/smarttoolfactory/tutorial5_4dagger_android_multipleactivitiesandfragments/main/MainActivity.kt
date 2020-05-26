package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.ToastMaker
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.R
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.model.SensorController
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 *
 * In this tutorial instead of using @ContributesAndroidInjector,
 * sub-component [MainActivitySubComponent], and it's sub-component
 * [FirstFragmentSubComponent] are created with interface that extend
 * AndroidInjector<MainActivity>, and AndroidInjector<FirstFragment>
 *
 *  🔥 Scope and component  determines the lifecycle of an injected object:
 *
 * [FirstFragment] contains mySharedPreferences instance from FirstFragmentModule
 * with @FragmentScope which is created each time [FirstFragment] is created.
 *
 * [ToastMaker] with @ActivityScope via [MainActivitySubComponent] lives as long
 * as the same [MainActivity] is alive, and not re-created whenever a fragment is created.
 *
 * 🔥🔥 [SecondFragment] has [SensorController] objected injected via constructor injection
 * with @ActivityScope that is only created whenever [MainActivity] is re-created
 *
 *
 */
class MainActivity : DaggerAppCompatActivity() {


    // Injected from AppModule with @Singleton
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /**
     * 🔥🔥🔥 Injected from [MainActivityModule] with @ActivityScope
     * which is the same object with [FirstFragment] and [SecondFragment]
     */
    @Inject
    lateinit var toastMaker: ToastMaker

    /**
     * 🔥🔥🔥 Injected via constructor injection with @ActivityScope
     * and same object with [SecondFragment]
     */
    @Inject
    lateinit var sensorController: SensorController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        toastMaker.showToast("MainActivity sharedPreferences $sharedPreferences")


        bindViews()
    }

    private fun bindViews() {

        findViewById<Button>(R.id.btn_first_frag).setOnClickListener {
            replaceFirstFragment()
        }
        replaceFirstFragment()

        replaceSecondFragment()

        findViewById<Button>(R.id.btn_second_frag).setOnClickListener {
            replaceSecondFragment()
        }

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "@ActivityScope toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor @ActivityScope sensorController: ${sensorController.hashCode()}"
    }

    private fun replaceFirstFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container1, FirstFragment()).commit()
    }

    private fun replaceSecondFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container2, SecondFragment()).commit()
    }

}