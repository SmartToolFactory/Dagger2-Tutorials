package com.example.tutorial1daggerbasics

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial1daggerbasics.model.MyExample
import java.util.*
import javax.inject.Inject

/**
 * This tutorial displays that injections through a application with a scope live as long as app is alive
 */
class MainActivity : AppCompatActivity() {


    /*
        This is a singleton object, MainActivity injects same object after device is rotated!
        it's a singleton object if and only it's in a Application level module
        and annotated with @Singleton or any scope
     */
    @Inject
    lateinit var mMyExample: MyExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val dateTextView = findViewById<TextView>(R.id.tv_date)

        (application as MyApplication)
                .myComponent
                .inject(this@MainActivity)

        dateTextView.text = Date(mMyExample.date).toString()

        println("MyExample: $mMyExample")

        Toast.makeText(this, "MyExample: $mMyExample", Toast.LENGTH_SHORT).show()
    }
}