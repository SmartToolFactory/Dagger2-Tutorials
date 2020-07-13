package com.test.tutorial4_7layerimplementation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.test.tutorial4_7layerimplementation.di.DaggerMainActivityComponent
import com.test.tutorial4_7layerimplementation.di.MainActivityModule
import com.test.tutorial4_7layerimplementation.model.User
import com.test.tutorial4_7layerlibrary.BaseApplication
import com.test.tutorial4_7layerlibrary.LibraryActivity
import com.test.tutorial4_7layerlibrary.di.BaseAppModule
import com.test.tutorial4_7layerlibrary.model.ActivityScopedObject
import com.test.tutorial4_7layerlibrary.model.LibraryObject
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    /**
     * Injected via Constructor Injection NO Scope from Library
     */
    // 🔥🔥  ❌ Compile ERROR: cannot be provided without an @Provides-annotated method because
    // of Context
//    @Inject
//    lateinit var sensorController: SensorController

    /**
     * Injected via Constructor Injection with @Singleton scope from Library
     */

    // 🔥🔥  ❌ Compile ERROR: may not reference bindings with different scopes:
//    @Inject
//    lateinit var singletonObject: SingletonObject

    /**
     * Injected via Constructor Injection with @Singleton scope from Library
     */
    @Inject
    lateinit var activityScopedObject: ActivityScopedObject


    /**
     * Injected from [BaseAppModule] with No Scope
     */
    @Inject
    lateinit var libraryObject: LibraryObject

    /**
     * Injected from [MainActivityModule] with @ActivityScope
     */
    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInjection()

        bindViews()

    }

    private fun bindViews() {
        findViewById<Button>(R.id.btn_second_activity).setOnClickListener {
            val intent = Intent(this@MainActivity, LibraryActivity::class.java)
            startActivity(intent)
        }


//        findViewById<TextView>(R.id.tvInfo).text =
//                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
//                        "@ActivityScope dummyDependency: ${dummyDependency.hashCode()}\n" +
//                        "Constructor @ActivityScope sensorController: ${sensorController.hashCode()}\n" +
//                        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"
    }


    private fun initInjection() {
        val baseComponent = BaseApplication.baseComponent(applicationContext)

        DaggerMainActivityComponent.builder()
                .baseAppComponent(baseComponent)
                .build()
                .inject(this)
    }

}