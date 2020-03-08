package com.fredporciuncula.assistedinject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fredporciuncula.simple_assisted_inject.R
import kotlinx.android.synthetic.main.activity_text.*

interface TextView {

  fun showText(text: String)
}

class TextActivity : AppCompatActivity(), TextView {

  companion object {
    private const val EXTRA_TEXT = "com.fredporciuncula.assistedinject.TEXT"

    fun newIntent(context: Context, text: String) =
      Intent(context, TextActivity::class.java).apply {
        putExtra(EXTRA_TEXT, text)
      }
  }

  private val presenter by lazy {
    component.textPresenterFactory.create(this, intent.getStringExtra(EXTRA_TEXT))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_text)
    presenter.onCreate()
  }

  override fun showText(text: String) {
    editText.text = text
  }
}
