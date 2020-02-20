package com.test.tutorial4_7layerlibrary.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.tutorial4_7layerlibrary.model.User;

public class BaseViewModel extends ViewModel {

    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public BaseViewModel() {

    }
}
