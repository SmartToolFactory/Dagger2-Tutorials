package com.fredporciuncula.assistedinject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fredporciuncula.simple_assisted_inject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    button.setOnClickListener {
      startActivity(TextActivity.newIntent(this, text = editText.text.toString()))
    }
  }
}
