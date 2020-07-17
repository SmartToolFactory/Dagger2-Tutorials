package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.R


class MainFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnHome = view.findViewById<Button>(R.id.btnHome)
        val btnCamera = view.findViewById<Button>(R.id.btnCamera)
        val btnPhotos = view.findViewById<Button>(R.id.btnPhotos)


        btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_homeFragment)
        }

        btnCamera.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_nav_graph_camera)
        }

        btnPhotos.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_nav_graph_photos)
        }
    }


}
