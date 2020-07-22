package com.smarttoolfactory.tutorial10_1dfm_daggerhilt.main


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.R
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.FragmentObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.MainActivityObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.MainFragmentObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.ToastMaker
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * This fragment uses Sub-Component MainFragmentSubComponent to inject dependencies.
 *
 * * MainActivity is the parent component so, any dependency with @ActivityScope is injected
 * both to this fragment and MainActivity
 */

@AndroidEntryPoint
class MainFragment : Fragment() {

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
     * 🔥🔥🔥 Injected from [MainActivityModule] with @ActivityScope
     * which is the same object with [MainActivity] and [MainFragment]
     */
    @Inject
    lateinit var mainActivityObject: MainActivityObject


    /**
     * Injected from [MainFragmentModule] with no scope
     */
    @Inject
    lateinit var mainFragmentObject: MainFragmentObject

    /**
     * Constructor injection with @FragmentScope
     */
    @Inject
    lateinit var fragmentObject: FragmentObject

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @SuppressLint("SetTextI18n")
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
//            findNavController().navigate(R.id.photoActivity)
        }

        view.findViewById<TextView>(R.id.tvInfo).text =
                "CoreModule @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
                        "CoreModule no scope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                        "MainActivityModule @ActivityScoped mainActivityObject: ${mainActivityObject.hashCode()}\n" +
                        "MainFragmentModule no scope mainFragmentObject: ${mainFragmentObject.hashCode()}\n" +
                        "MainActivityModule no scope toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor @FragmentScoped fragmentObject: ${fragmentObject.hashCode()}"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        initSubComponentInjection()
        super.onCreate(savedInstanceState)
    }

    private fun initSubComponentInjection() {
//        val mainFragmentSubComponent = (activity as MainActivity).mainActivityComponent
//                .mainFragmentFactory().create()
//        mainFragmentSubComponent.inject(this) // cannot be in onAttach because of SavedStateHandle
    }

}
