package com.smarttoolfactory.gallery

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.gallery.di.DaggerGalleryComponent
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.MyApplication
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.AnyDependency
import javax.inject.Inject

class GalleryActivity : AppCompatActivity() {

    @Inject
    lateinit var anyDependency: AnyDependency

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var galleryViewer: GalleryViewer

//    @Inject
//    lateinit var dummyDependency: DummyDependency



    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerGalleryComponent.builder()
                .appComponent((application as MyApplication).appComponent)
                .build()
                .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        findViewById<TextView>(R.id.tvInfo).text =
                "ApplicationModule anyDependency: ${anyDependency.hashCode()}\n" +
                "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
//                        "GalleryModule @GalleryScope  dummyDependency: ${dummyDependency.hashCode()}\n" +
                        "GalleryModule @GalleryScope galleryViewer: ${galleryViewer.hashCode()}"

        Toast.makeText(this, "Gallery Feature is started", Toast.LENGTH_SHORT).show()
    }
}