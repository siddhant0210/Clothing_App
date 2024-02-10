package com.example.re_wear.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.re_wear.R
import com.example.re_wear.adapters.HomeViewPagerAdapter
import com.example.re_wear.fragments.categories.AccessoryFragment
import com.example.re_wear.fragments.categories.MenFragment
import com.example.re_wear.fragments.categories.SportsFragment
import com.example.re_wear.fragments.categories.WomenFragment
import com.example.re_wear.fragments.categories.MainCategoryFragment
import com.example.re_wear.fragments.categories.KidsFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            MenFragment(),
            SportsFragment(),
            KidsFragment(),
            AccessoryFragment(),
            WomenFragment()
        )

        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)

        viewPager2.adapter = HomeViewPagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Main"
                1 -> tab.text = "Men"
                2 -> tab.text = "Women"
                3 -> tab.text = "Kids"
                4 -> tab.text = "Accessory"
                5 -> tab.text = "Sports"
                else -> tab.text = " Main"
            }
        }.attach()

    }

}