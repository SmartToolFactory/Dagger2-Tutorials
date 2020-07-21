package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial9_2core.di.CoreModule
import com.smarttoolfactory.tutorial9_2core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial9_2core.model.CoreDependency
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di.DaggerMainActivityComponent
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di.MainActivityComponent
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di.MainActivityModule
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.MainActivityObject
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.SensorController
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.ToastMaker
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

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
     * Injected from [MainActivityModule] with @ActivityScope
     * * To inject this there should be @Binds that gets Context from an Application
     */
    @Inject
    lateinit var mainActivityDependency: MainActivityObject

    /**
     * Injected via constructor injection with no scope
     */
    @Inject
    lateinit var sensorController: SensorController

    /**
     * ❌ Cannot inject object with @Singleton or any scope other than [MainActivityModule] has, to this class
     * from this module
     *
     * ### Error: may not reference bindings with different scopes: public abstract interface MainActivityComponent extends
     */
//    @Inject
//    lateinit var singletonObject: SingletonObject

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        initCoreDependentInjection()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvInfo).text =
                "CoreModule @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
                        "CoreModule @ActivityScope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                        "MainActivityModule no scope  mainActivityDependency: ${mainActivityDependency.hashCode()}\n" +
                        "MainActivityModule no scope toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor no scope sensorController: ${sensorController.hashCode()}\n"
    }

    private fun initCoreDependentInjection() {

        mainActivityComponent = DaggerMainActivityComponent.factory()
                .create(
                        coreComponent = coreComponent(),
                        mainActivityModule = MainActivityModule(),
                        application = application
                )

        mainActivityComponent.inject(this)
    }


}