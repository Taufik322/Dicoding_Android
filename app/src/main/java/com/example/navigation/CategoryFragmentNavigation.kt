package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.dicodingandroid.R
import com.example.dicodingandroid.databinding.FragmentCategoryNavigationBinding

class CategoryFragmentNavigation : Fragment() {

    private var _binding : FragmentCategoryNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryNavigationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategoryLifestyle.setOnClickListener { view ->
           val toDetailCategoryFragmentNavigation = CategoryFragmentNavigationDirections.actionCategoryFragmentNavigationToDetailCategoryFragmentNavigation()
            toDetailCategoryFragmentNavigation.name = "Lifestyle"
            toDetailCategoryFragmentNavigation.stock = 7
            view.findNavController().navigate(toDetailCategoryFragmentNavigation)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_STOCK = "extra_stock"
    }
}