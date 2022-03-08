package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.dicodingandroid.R
import com.example.dicodingandroid.databinding.FragmentDetailCategoryNavigationBinding

class DetailCategoryFragmentNavigation : Fragment() {

    private var _binding: FragmentDetailCategoryNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailCategoryNavigationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataName = DetailCategoryFragmentNavigationArgs.fromBundle(arguments as Bundle).name
        val dataDesc = DetailCategoryFragmentNavigationArgs.fromBundle(arguments as Bundle).stock

        binding.tvCategoryNameNav.text = dataName
        binding.tvCategoryDescriptionNav.text = "Stock: $dataDesc"

        binding.btnProfileNav.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragmentNavigation_to_homeFragmentNavigation)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}