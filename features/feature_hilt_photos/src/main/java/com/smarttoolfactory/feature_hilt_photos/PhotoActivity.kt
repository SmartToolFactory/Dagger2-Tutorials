package com.smarttoolfactory.feature_hilt_photos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.feature_hilt_photos.di.DaggerPhotoComponent
import com.smarttoolfactory.tutorial10_1core.di.CoreComponent
import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class PhotoActivity : AppCompatActivity() {

    @Inject
    lateinit var coreDependency: CoreDependency


    @Inject
    lateinit var coreActivityDependency: CoreActivityDependency

    override fun onCreate(savedInstanceState: Bundle?) {

        initHiltDependencyInjection()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        findViewById<TextView>(R.id.tvInfo).text =
                "CoreModule @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
                        "CoreModule no scope coreActivityDependency: ${coreActivityDependency.hashCode()}\n"
//                "MainActivityModule no scope toastMaker: ${toastMaker.hashCode()}\n" +
//                        "MainActivityModule @ActivityScope mainActivityObject: ${mainActivityObject.hashCode()}\n" +
//                        "PhotoModule @FeatureScope photoObject: ${photoObject.hashCode()}\n" +
//                "Constructor no scope sensorController: ${sensorController.hashCode()}"
    }

    private fun initHiltDependencyInjection() {

        DaggerPhotoComponent.factory().create(
                EntryPointAccessors.fromApplication(
                        applicationContext,
                        CoreComponent::class.java
                ),
                application
        )
                .inject(this)


    }


}