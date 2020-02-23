package com.example.tutorial4_3componentbuilders

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

/**
 * @BinsIntance annotation binds an object to DaggerAppComponent via
 *
 * @Override
 * public Builder application(Application application) {
 *    this.application = Preconditions.checkNotNull(application);
 *    return this;
 * }
 * method of generated [DaggerAppComponentWithBindsInstance] class.
 *
 * Note that forgetting to add objects, in this example Application, that annotated
 * with @BindsInstance causes
 * java.lang.IllegalStateException: android.app.Application must be set
 *
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Gets regular AppComponent
//        (application as MyApplication).appComponent.inject(this)

        // Gets AppComponent with @BindsInstance
        (application as MyApplication).appComponentWithBindsInstance.inject(this)

        println("MainActivity mSharedPreferences: $sharedPreferences")


        val editor = sharedPreferences.edit()
        editor.putInt("data", 13)
        editor.apply()
        val data = sharedPreferences.getInt("data", 0)
        Toast.makeText(this, "Data: $data", Toast.LENGTH_SHORT).show()
    }
}