package com.fredporciuncula.assistedinject

import android.content.Context
import com.fredporciuncula.simple_assisted_inject.R
import javax.inject.Inject

class TextDecorator @Inject constructor(
  private val context: Context
) {

  fun decorate(text: String) = context.getString(R.string.decoration_template, text)
}
