package com.smarttoolfactory.gallery

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.gallery.di.DaggerGalleryComponent
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.MyApplication

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        Toast.makeText(this, "Gallery Feature is started", Toast.LENGTH_SHORT).show()

        DaggerGalleryComponent.builder()
                .appComponent((application as MyApplication).appComponent)
                .build()
                .inject(this)
    }
}