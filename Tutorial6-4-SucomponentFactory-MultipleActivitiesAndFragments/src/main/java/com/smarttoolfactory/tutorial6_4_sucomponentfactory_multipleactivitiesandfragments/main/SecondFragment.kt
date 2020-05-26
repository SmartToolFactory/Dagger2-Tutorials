package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.R
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model.FragmentObject
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model.MySharedPreferences
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model.SensorController
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model.ToastMaker
import javax.inject.Inject

class SecondFragment : Fragment() {

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
    lateinit var sensorController: SensorController

    override fun onCreate(savedInstanceState: Bundle?) {
        initInjections()

        super.onCreate(savedInstanceState)
    }

    private fun initInjections() {
        val secondFragmentSubComponent = (activity as MainActivity).mainActivityComponent
                .secondFragmentFactory().create()
        secondFragmentSubComponent.inject(this) // cannot be in onAttach because of SavedStateHandle
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvInfo).text =
                "Frag: $this\n" +
                        "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "SecondFragmentModule @FragmentScope mySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "MainActivityModule @ActivityScope toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor @FragmentScope fragObject: ${fragmentObject.hashCode()}\n" +
                        "Constructor @ActivityScope sensorController: ${sensorController.hashCode()}"
    }
}