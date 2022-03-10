package com.example.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = HomeFragmentTabLayout()
        fragment.arguments = Bundle().apply {
            putInt(HomeFragmentTabLayout.ARG_SECTION_NUMBER, position + 1)
        }
        return fragment as Fragment
    }
}