package com.test.tutorial4_7layerimplementation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.test.tutorial4_7layerimplementation.di.DaggerMainActivityComponent
import com.test.tutorial4_7layerimplementation.model.User
import com.test.tutorial4_7layerlibrary.BaseApplication
import com.test.tutorial4_7layerlibrary.LibraryActivity
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

//    // Injected from ApplicationModule
//    @Inject
//    lateinit var sharedPreferences: SharedPreferences
//
//    // Constructor Injection
//    @Inject
//    lateinit var sensorController: SensorController
//
//    // 🔥 Injected via Constructor Injection with @Singleton scope
//    @Inject
//    lateinit var singletonObject: SingletonObject

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