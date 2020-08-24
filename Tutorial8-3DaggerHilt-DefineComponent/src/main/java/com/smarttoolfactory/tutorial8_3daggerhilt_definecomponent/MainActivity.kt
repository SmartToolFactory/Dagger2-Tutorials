package com.smarttoolfactory.tutorial8_3daggerhilt_definecomponent

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial8_3daggerhilt_definecomponent.model.ApplicationObject
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var applicationObject: ApplicationObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Toast.makeText(this, "applicationObject: $applicationObject", Toast.LENGTH_SHORT).show()

    }

}