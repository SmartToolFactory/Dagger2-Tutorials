package com.smarttoolfactory.tutorial7_2bindsvsprovides2.model

import javax.inject.Inject

class ToasterImpl @Inject constructor(): Toaster {

    override fun makeToast() {
        println("ToasterImp makeToast() $this")
    }

}