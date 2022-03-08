package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.dicodingandroid.R
import com.example.dicodingandroid.databinding.FragmentHomeNavigationBinding

class HomeFragmentNavigation : Fragment() {
    private var _binding: FragmentHomeNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeNavigationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategory.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragmentNavigation_to_categoryFragmentNavigation)
        )
        binding.btnProfile.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homeFragmentNavigation_to_profileActivityNavigation)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}