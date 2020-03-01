package com.smarttoolfactory.tutorial6_3subcomponentfactory

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.DummyDependency
import javax.inject.Inject

/**
 * Component and SubComponent Factory can be used to replace Builders
 *
 * For Application Component create SubComponent factories with XSubComponent.Factory
 * and SubComponents should have inject() and create() methods to be able to inject to
 * Activity, Fragment or objects.
 *
 * 🔥 @ActivityScope on [ActivityScopedFragment] does not mean their objects live through
 * Activity lifecycle. Whenever [ActivityScopedFragment] fragment is replaced
 * new dependencies are created!!!
 */
/*
 ONLY one component can inject to an Object
 */
class MainActivity : AppCompatActivity() {

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from DummyDependencyModule
    @Inject
    lateinit var dummyDependency: DummyDependency


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInjection()

        bindViews()


    }

    private fun bindViews() {
        findViewById<Button>(R.id.button_second_activity).setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_first_frag).setOnClickListener {
            replaceFirstFragment()
        }
        replaceFirstFragment()

        findViewById<Button>(R.id.btn_second_frag).setOnClickListener {
            replaceSecondFragment()
        }
        replaceSecondFragment()

        findViewById<TextView>(R.id.tvInfo).text = "DummyDependenyc: ${dummyDependency.hashCode()}\n" +
                "sharedPreferences: ${sharedPreferences.hashCode()}"
        println("MainActivity sharedPreferences: $sharedPreferences")
        Toast.makeText(this, "MainActivity: $sharedPreferences", Toast.LENGTH_SHORT).show()
    }

    private fun replaceFirstFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container1, FragScopedFragment()).commit()
    }

    private fun replaceSecondFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container2, ActivityScopedFragment()).commit()
    }

    private fun initInjection() {

        val appComponent = (application as MyApplication).appComponent

        // 🔥SubComponent Builder
//        val dummyDependencyComponent = appComponent
//                .dummyDependencyBuilder()
//                .context(this)
//                .build()

        // 🔥 SubComponent Factory
        val dummyDependencyComponent = appComponent
                .dummyDependencyComponentFactory
                .create(this)

        dummyDependencyComponent.inject(this)
    }


}
