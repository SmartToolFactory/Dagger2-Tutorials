package com.smarttoolfactory.gallery

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.gallery.di.DaggerGalleryComponent
import com.smarttoolfactory.gallery.di.GalleryModule
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.MyApplication
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.DummyDependency
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.ToastMaker
import javax.inject.Inject

class GalleryActivity : AppCompatActivity() {


    /**
     * Injected from [AppModule] with @Singleton scope
     */
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /**
     * Injected from [AppModule] with no scope
     */
    @Inject
    lateinit var toastMaker: ToastMaker

    @Inject
    lateinit var galleryViewer: GalleryViewer

    @Inject
    lateinit var dummyDependency: DummyDependency

    override fun onCreate(savedInstanceState: Bundle?) {

        initInjections()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule toastMaker: ${toastMaker.hashCode()}\n" +
                        "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "GalleryModule @GalleryScope  dummyDependency: ${dummyDependency.hashCode()}\n" +
                        "GalleryModule @GalleryScope galleryViewer: ${galleryViewer.hashCode()}"

        Toast.makeText(this, "Gallery Feature is started", Toast.LENGTH_SHORT).show()
    }

    private fun initInjections() {

        // TODO Alternative1 With Builder
//        DaggerGalleryComponent.builder()
//                .appComponent((application as MyApplication).appComponent)
//                .application(application)
//                .galleryModule(GalleryModule())
//                .build()
//                .inject(this)

        // TODO Alternative2 With Factory
        DaggerGalleryComponent
                .factory()
                .create((application as MyApplication).appComponent, GalleryModule(), application)
                .inject(this)

    }
}