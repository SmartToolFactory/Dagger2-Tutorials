package com.smarttoolfactory.tutorial6_3subcomponentfactory

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.MySharedPreferences
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.ToastMaker
import javax.inject.Inject

/**
 * ToastMakerModule and MySharedPreferencesModule are scoped with @FragmentScope
 */
class SecondActivity : AppCompatActivity() {

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from ToastMakerModule
    @Inject
    lateinit var toastMaker: ToastMaker

    // Injected from MySharedPreferencesModule
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initInjection()

        findViewById<TextView>(R.id.tvInfo).text = "ToastMaker: ${toastMaker.hashCode()}\n" +
                "mySharedPreferences: ${mySharedPreferences.hashCode()}"

        toastMaker.showToast("SharedPreferences: $sharedPreferences")

    }

    private fun initInjection() {

        val appComponent = (application as MyApplication).appComponent


        // 🔥SubComponent Builder
//        val toastMakerSubComponent = appComponent
//                .toastMakerBuilder()
//                .context(this)
//                .build()

        // 🔥 SubComponent Factory
        val toastMakerSubComponent = appComponent
                .toastAndSharedPreferencesFactory
                .create(this)

        toastMakerSubComponent.inject(this)


    }
}