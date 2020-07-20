package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.MyApplication
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.R
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.ActivitySubComponentsModule
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.AppComponent
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.FragmentSubComponentsModule
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model.SensorController
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model.ToastMaker
import javax.inject.Inject


/**
 * This tutorial shows how to create sub component example which has
 * same hierarchy with Tutorial
 *
 * Steps to follow:
 *
 * * 1- Create [AppComponent] and add [ActivitySubComponentsModule]
 * to modules. [MainActivitySubComponent] is added to [ActivitySubComponentsModule]
 * as sub-component.
 *
 * * 2- Create [FragmentSubComponentsModule] which includes
 * [FirstFragmentSubComponent] and [SecondFragmentSubComponent] for injecting fragment dependencies
 * to fragments and add it to [MainActivitySubComponent]
 *
 * * 3- Get [MainActivitySubComponent.Factory] from [AppComponent] and inject to [MainActivity]
 *  to be able to inject dependencies of [MainActivity]
 *
 * * 4- Get [FirstFragmentSubComponent.Factory] and [SecondFragmentSubComponent.Factory] from
 * [MainActivitySubComponent] and inject to [FirstFragment] and [SecondFragment]
 *
 */
class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivitySubComponent

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

        initInjection()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()

    }

    private fun initInjection() {

        val appComponent = (application as MyApplication).appComponent

        mainActivityComponent = appComponent
                .mainActivityComponentFactory()
                .create(this)

        mainActivityComponent.inject(this)
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
                        "🔥 MainActivityModule @ActivityScope toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor @ActivityScope sensorController: ${sensorController.hashCode()}"

        Toast.makeText(this, "MainActivity: $sharedPreferences", Toast.LENGTH_SHORT).show()
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
