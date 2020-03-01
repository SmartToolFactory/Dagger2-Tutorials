package com.smarttoolfactory.tutorial6_3subcomponentfactory

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.MySharedPreferences
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.ToastMaker
import javax.inject.Inject

class MyFragment : Fragment() {

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from MySharedPreferencesModule
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    // Injected from ToastMakerModule
    @Inject
    lateinit var toastMaker: ToastMaker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initInjection()

        toastMaker.showToast("Toast from Fragment $sharedPreferences")
        mySharedPreferences.putData("data", 12)
        toastMaker.showToast("Data from Fragment: " + mySharedPreferences.getData("data"))
    }

    private fun initInjection() {

        val appComponent = (activity!!.application as MyApplication).appComponent

        // 🔥SubComponent Builder
//        val toastMakerSubComponent = appComponent
//                .toastMakerBuilder()
//                .context(activity!!)
//                .build()

        // 🔥 SubComponent Factory
        val toastMakerSubComponent = appComponent
                .toastAndSharedPreferencesFactory
                .create(activity!!)

        toastMakerSubComponent.inject(this)
    }
}