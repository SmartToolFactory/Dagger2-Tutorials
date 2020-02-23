package com.example.tutorial2selectcontructorandfieldinjection

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @Named("Field")
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    @Inject
    lateinit var mySharedPreferencesConstructor: MySharedPreferences

    private var data1 = 0
    private var data2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as MyApplication).myComponent.inject(this)

        // @ Inject calls this constructor of MySharedPreferences class after injecting SharedPreferences to it
        // SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PrefName", Context.MODE_PRIVATE);
        // mySharedPreferences = new MySharedPreferences(sharedPreferences);

        println("Field Injected: $mySharedPreferences")
        println("Constructor Injected: $mySharedPreferencesConstructor")
        mySharedPreferences!!.putData("info", 0)
        mySharedPreferencesConstructor!!.putData("info", 0)
        data1 = mySharedPreferences!!.getData("info")
        data2 = mySharedPreferencesConstructor!!.getData("info")

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)

        button1.setOnClickListener {
            data1 += 3
            mySharedPreferences!!.putData("info", data1)
            textView1.text = "Field injected: " + mySharedPreferences!!.getData("info")
        }
        button2.setOnClickListener {
            data2 += 5
            mySharedPreferencesConstructor!!.putData("info", data2)
            textView2.text = "Constructor injected: " + mySharedPreferencesConstructor!!.getData("info")
        }
    }
}