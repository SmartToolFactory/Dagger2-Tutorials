package com.example.tutorial2injectconstructor

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial2injectconstructor.model.MySharedPreferences
import javax.inject.Inject

/**
 * This tutorial shows that objects can be injected via constructor injection. If an object
 * can be created via constructor, it should be selected instead of @Provides.
 *
 * @Inject calls this constructor of MySharedPreferences class after injecting SharedPreferences to it
 *
 * @Singleton or any annotation before constructor of object makes it Singleton
 */
class MainActivity : AppCompatActivity() {

    // Constructor injection
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as MyApplication).myComponent.inject(this)

        // @ Inject calls this constructor of MySharedPreferences class after injecting SharedPreferences to it

        // @ Inject is same as calling code below
//        val sharedPreferences = applicationContext.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
//        mySharedPreferences = MySharedPreferences(sharedPreferences)


        findViewById<TextView>(R.id.tvInfo).text = "mySharedPreferences: $mySharedPreferences"

        println("MySharedPreferences: $mySharedPreferences")
        mySharedPreferences.putData("info", 10)

        val data = mySharedPreferences.getData("info")
        Toast.makeText(this, "DATA: $data", Toast.LENGTH_SHORT).show()
    }
}