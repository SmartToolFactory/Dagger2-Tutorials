package com.test.tutorial4_8layerlibrary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.tutorial4_8layerlibrary.model.User

class BaseViewModel : ViewModel() {
    private val stringMutableLiveData = MutableLiveData<String>()
    private val userMutableLiveData = MutableLiveData<User>()
}