package com.test.tutorial4_7layerlibrary

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.test.tutorial4_7layerlibrary.model.ToastMaker
import com.test.tutorial4_7layerlibrary.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var viewModel: BaseViewModel

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var toastMaker: ToastMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        println("BaseActivity sharedPreferences: $sharedPreferences")
        toastMaker.showToast("BaseActivity Toast")

        viewModel = ViewModelProvider(this).get(BaseViewModel::class.java)
    }
}