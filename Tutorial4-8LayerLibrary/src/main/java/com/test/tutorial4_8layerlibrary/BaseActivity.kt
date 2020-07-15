package com.test.tutorial4_8layerlibrary

import android.content.SharedPreferences
import android.os.Bundle
import com.test.tutorial4_8layerlibrary.model.DummyModel
import com.test.tutorial4_8layerlibrary.model.ToastMaker
import com.test.tutorial4_8layerlibrary.model.User
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var toastMaker: ToastMaker

    @Inject
    lateinit var user: User

    @Inject
    lateinit var dummyModel: DummyModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("BaseActivity sharedPreferences: $sharedPreferences")
        println("BaseActivity user: " + user!!.name + ", email: " + user!!.email)
        toastMaker.showToast("BaseActivity Toast")
        System.out.println("BaseActivity result: " + (application as BaseApplication).testResult())
    }
}