package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.ToastMaker
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.R
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.model.FragmentObject
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.model.MySharedPreferences
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.model.SensorController
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SecondFragment : DaggerFragment() {

    // Injected from AppModule with @Singleton
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /**
     * Injected from [SecondFragmentModule] with @FragmentScope which
     * is created each time an instance of this fragment is created.
     */
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    /**
     * 🔥🔥🔥 Injected from [MainActivityModule] with @ActivityScope
     * which is the same object with [MainActivity] and [FirstFragment]
     */
    @Inject
   lateinit var toastMaker: ToastMaker

    /**
     * Injected via constructor injection with @FragmentScope
     */
    @Inject
    lateinit var fragmentObject: FragmentObject

    /**
     * 🔥🔥🔥 Injected via constructor injection with @ActivityScope
     * and same object with [MainActivity]
     */
    @Inject
    lateinit var  sensorController: SensorController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvInfo).text =
                "Frag: $this\n" +
                        "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "SecondFragmentModule @FragmentScope mySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "MainActivityModule @ActivityScope toastMaker: ${toastMaker.hashCode()}\n"+
                        "Constructor @FragmentScope fragObject: ${fragmentObject.hashCode()}\n" +
                        "Constructor @ActivityScope sensorController: ${sensorController.hashCode()}"
    }
}