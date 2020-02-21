package com.example.tutorial3scope1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial3scope1.model.User
import javax.inject.Inject

class Activity2 : AppCompatActivity() {

    /**
     * This user is a Singleton object since it's using UserComponent of Application
     */
    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_123)

        (application as MyApplication).userComponent.inject(this)


        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this@Activity2, Activity3::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.textView).text = "Second User: " + user.hashCode()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Activity2 onDestroy()", Toast.LENGTH_SHORT).show()
    }
}