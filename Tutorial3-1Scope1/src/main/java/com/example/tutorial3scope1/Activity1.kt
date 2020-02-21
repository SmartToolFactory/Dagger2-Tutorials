package com.example.tutorial3scope1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial3scope1.di.DaggerUserComponent
import com.example.tutorial3scope1.di.UserComponent
import com.example.tutorial3scope1.model.User
import javax.inject.Inject

/**
 * In this tutorial it's shown that components created by an Activity only lives through lifecycle of
 * that Activity whether it's scoped to be singleton or with local scope
 */
class Activity1 : AppCompatActivity() {

    private val userComponent: UserComponent by lazy {
        DaggerUserComponent.create()
    }

    // This User is created each time device is rotated
    // 🔥 UserComponent is created by this Activity, so every time it's created new UserComponent is
    // created, exiting a scope is as simple as dropping all references to the component instance

    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_123)

        userComponent.inject(this)

        findViewById<TextView>(R.id.textView).text = "Main User: " + user.hashCode()

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this@Activity1, Activity2::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Activity1 onDestroy()", Toast.LENGTH_SHORT).show()
    }
}