package com.test.tutorial4_7layerimplementation

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.test.tutorial4_7layerimplementation.di.DaggerMainActivityComponent
import com.test.tutorial4_7layerimplementation.di.MainActivityModule
import com.test.tutorial4_7layerimplementation.model.User
import com.test.tutorial4_7layerlibrary.BaseApplication
import com.test.tutorial4_7layerlibrary.LibraryActivity
import com.test.tutorial4_7layerlibrary.di.BaseAppComponent
import com.test.tutorial4_7layerlibrary.di.BaseAppModule
import com.test.tutorial4_7layerlibrary.model.ActivityScopedObject
import com.test.tutorial4_7layerlibrary.model.LibraryObject
import com.test.tutorial4_7layerlibrary.model.ToastMaker
import javax.inject.Inject

/**
 * In this tutorial [MainActivityComponent] depends on [BaseAppComponent]
 * * To inject objects from [BaseAppComponent], [BaseAppComponent] should have provision methods
 * other than @Provides
 *
 * * MainActivityComponent should have a [Component.Builder] with baseComponent()`, `application()`
 * and `mainActivityModule()` methods
 *
 *
 */
class MainActivity : AppCompatActivity() {


    /**
     *  Injected from BaseAppComponent with @Singleton
     */
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /**
     *  Injected from BaseAppComponent with @Singleton
     */
    @Inject
    lateinit var toastMaker: ToastMaker


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


        findViewById<TextView>(R.id.tvInfo).text =
                "AppModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "AppModule toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor @ActivityScope activityScopedObject: ${activityScopedObject.hashCode()}\n" +
                        "Constructor @Singleton singletonObject: ${libraryObject.hashCode()}"

    }


    private fun initInjection() {
        val baseComponent = BaseApplication.baseComponent(applicationContext)

        DaggerMainActivityComponent.builder()
                .baseAppComponent(baseComponent)
                .mainActivityModule(MainActivityModule())
                .application(application)
                .build()
                .inject(this)
    }

}