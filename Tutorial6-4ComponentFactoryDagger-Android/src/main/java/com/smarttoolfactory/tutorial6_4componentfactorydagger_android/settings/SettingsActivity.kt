package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.settings

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SettingsActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        replaceFragment()
    }


    private fun replaceFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.settings_container, SettingsFragment()).commit()
    }

}