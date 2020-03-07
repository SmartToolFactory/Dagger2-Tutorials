package com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.model.MySharedPreferences
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.model.SensorController
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.model.SingletonObject
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.model.ToastMaker
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.R
import javax.inject.Inject

class FirstFragment : Fragment() {

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from MySharedPreferencesModule @FragmentScope
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    // Injected from ToastMakerModule @FragmentScope
    @Inject
    lateinit var toastMaker: ToastMaker

    // Injected via Constructor Injection NOT Singleton
    @Inject
    lateinit var sensorController: SensorController

    // 🔥 Injected via Constructor Injection with @Singleton scope
    @Inject
    lateinit var singletonObject: SingletonObject
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tvInfo).text =
                "Frag: $this\n" +
                        "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "@FragmentScope MySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "Constructor Un-scoped sensorController: ${sensorController.hashCode()}\n"+
                        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"

    }

    private fun initInjection() {
        val applicationComponent = (activity!!.application as MyApplication).applicationComponent

        val toastMakerSubComponent = applicationComponent
                .toastMakerBuilder()
                .context(activity!!)
                .build()
        toastMakerSubComponent.inject(this)
    }
}