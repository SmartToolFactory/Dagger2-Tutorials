package com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.main

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.R
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model.SensorController
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model.ToastMaker
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Tutorial fro implementing subcomponents and scopes presented in Tutorial 6-4 using Dagger Hilt.
 *
 * * You can either use single module for FragmentComponent, or other pre-defined Hilt components,
 * for instance or use several
 * modules like in regular module.
 *
 * * Do not use put same provide methods for same dependencies without qualifier
 * in several modules.
 *
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /**
     *  Injected from AppModule with @Singleton
     */
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

        bindViews()

    }


    private fun bindViews() {

        findViewById<Button>(R.id.btn_first_frag).setOnClickListener {
            replaceFirstFragment()
        }
        replaceFirstFragment()

        findViewById<Button>(R.id.btn_second_frag).setOnClickListener {
            replaceSecondFragment()
        }
        replaceSecondFragment()

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "🔥 MainActivityModule @ActivityScoped toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor @ActivityScoped sensorController: ${sensorController.hashCode()}"
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
