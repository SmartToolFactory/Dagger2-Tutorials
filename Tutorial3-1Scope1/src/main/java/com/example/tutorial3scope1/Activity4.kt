package com.example.tutorial3scope1

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial3scope1.model.User
import javax.inject.Inject

class Activity4 : AppCompatActivity() {


    /**
     * User is Singleton since it uses UserComponent of Application
     */
    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        (application as MyApplication).userComponent.inject(this)

        findViewById<TextView>(R.id.textView).text = "Fourth User: " + user.hashCode()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "FourthActivity onDestroy()", Toast.LENGTH_SHORT).show()
    }
}