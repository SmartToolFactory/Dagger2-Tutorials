package com.example.tutorial3scope1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial3scope1.di.DaggerUserComponent
import com.example.tutorial3scope1.model.User
import javax.inject.Inject

class Activity3 : AppCompatActivity() {

    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_123)

        val daggerUserComponent = DaggerUserComponent.create()
        daggerUserComponent.inject(this)


        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this@Activity3, Activity4::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.textView).text = "Third User: " + user.hashCode()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Activity3 onDestroy()", Toast.LENGTH_SHORT).show()
    }
}