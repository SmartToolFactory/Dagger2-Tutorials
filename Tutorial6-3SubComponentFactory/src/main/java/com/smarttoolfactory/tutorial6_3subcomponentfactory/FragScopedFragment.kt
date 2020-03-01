package com.smarttoolfactory.tutorial6_3subcomponentfactory

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.MySharedPreferences
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.ToastMaker
import javax.inject.Inject

/**
 * ToastMakerModule and MySharedPreferencesModule are scoped with @FragmentScope
 */
class FragScopedFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tvInfo).text =
                "Frag: $this\n" +
                        "ToastMaker: ${toastMaker.hashCode()}\n" +
                        " mySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "sharedPreferences: ${sharedPreferences.hashCode()}"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initInjection()

        toastMaker.showToast("${this.javaClass.simpleName} Toast from Fragment $sharedPreferences")
        mySharedPreferences.putData("data", 12)
        toastMaker.showToast("${this.javaClass.simpleName} Data from Fragment: " + mySharedPreferences.getData("data"))
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