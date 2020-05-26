package com.test.tutorial4_7layerlibrary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {

    private val stringMutableLiveData = MutableLiveData<String>()
}