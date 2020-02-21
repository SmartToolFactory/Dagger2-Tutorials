package com.test.tutorial3_3qualifiers

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.test.tutorial3_3qualifiers.di.CustomUser
import com.test.tutorial3_3qualifiers.model.User
import javax.inject.Inject

/**
 * We can inject various instances of same class with different properties using @Qualifier annotation of dagger 2
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var genericUser: User

    @CustomUser
    @Inject
    lateinit var customUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication)
                .userComponent
                .inject(this@MainActivity)

        findViewById<TextView>(R.id.tvInfo).text = "Generic user: $genericUser, Custom user: $customUser"
    }
}