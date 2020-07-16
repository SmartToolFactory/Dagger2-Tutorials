package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial9_2core.di.CoreComponent
import com.smarttoolfactory.tutorial9_2core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial9_2core.model.CoreDependency
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di.DaggerMainActivityComponent
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di.MainActivityComponent
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di.MainActivityModule
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.MainActivityDependency
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.SensorController
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.ToastMaker
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /**
     * Injected from [CoreComponent] with @Singleton scope
     */
    @Inject
    lateinit var coreDependency: CoreDependency

    /**
     * Injected from [CoreComponent] with no scope
     */
    @Inject
    lateinit var coreActivityDependency: CoreActivityDependency

    /**
     * Injected from [MainActivityComponent] with no scope
     */
    @Inject
    lateinit var toastMaker: ToastMaker


    /**
     *
     * Injected from [MainActivityComponent] with @ActivityScope
     * * To inject this there should be @Binds that gets Context from an Application
     */
    @Inject
    lateinit var mainActivityDependency: MainActivityDependency

    @Inject
    lateinit var sensorController: SensorController

    /**
     * ❌ Cannot inject object with @Singleton or any scope other than [MainActivityComponent] has to this class
     * from this module
     *
     * ### Error: may not reference bindings with different scopes: public abstract interface MainActivityComponent extends
     */
//    @Inject
//    lateinit var singletonObject: SingletonObject

    override fun onCreate(savedInstanceState: Bundle?) {

        initInjection()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvInfo).text =
                "CoreComponent @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
                        "CoreComponent no scope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                        "MainActivityModule no scope toastMaker: ${toastMaker.hashCode()}\n" +
                        "MainActivityModule @ActivityScope mainActivityDependency: ${mainActivityDependency.hashCode()}\n" +
                        "Constructor no scope sensorController: ${sensorController.hashCode()}"
    }

    private fun initInjection() {
        DaggerMainActivityComponent.factory()
                .create(
                        coreComponent = coreComponent(),
                        mainActivityModule = MainActivityModule(),
                        application = application
                )
                .inject(this)
    }


}