package com.fredporciuncula.assistedinject

import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import javax.inject.Qualifier

@Qualifier private annotation class Text

class TextPresenter @AssistedInject constructor(
  @Assisted private val view: TextView,
  @Assisted @Text private val text: String,
  private val textDecorator: TextDecorator
) {

  @AssistedInject.Factory
  interface Factory {
    fun create(view: TextView, @Text text: String): TextPresenter
  }

  fun onCreate() {
    view.showText(textDecorator.decorate(text))
  }
}
