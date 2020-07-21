package com.smarttoolfactory.tutorial10_1dfm_daggerhilt

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial10_1core.di.CoreModule
import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.di.MainActivityModule
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.MainActivityObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.SensorController
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.ToastMaker
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /**
     * Injected from [CoreModule] with @Singleton scope
     */
    @Inject
    lateinit var coreDependency: CoreDependency

    /**
     * Injected from [CoreModule] with no scope
     */
    @Inject
    lateinit var coreActivityDependency: CoreActivityDependency

    /**
     * Injected from [MainActivityModule] with no scope
     */
    @Inject
    lateinit var toastMaker: ToastMaker

    /**
     *
     * Injected from [MainActivityModule] with @ActivityScoped
     * * To inject this there should be @Binds that gets Context from an Application
     */
    @Inject
    lateinit var mainActivityObject: MainActivityObject

    /**
     * Injected via constructor injection with no scope
     */
    @Inject
    lateinit var sensorController: SensorController

    /**
     * Injected via constructor injection with @Singleton scope
     */
//    @Inject
//    lateinit var singletonObject: SingletonObject

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvInfo).text =
                "CoreModule @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
                        "CoreModule @ActivityScope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                        "MainActivityModule @ActivityScoped mainActivityObject: ${mainActivityObject.hashCode()}\n" +
                        "MainActivityModule no scope toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor no scope sensorController: ${sensorController.hashCode()}\n"
//                        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"


    }
}