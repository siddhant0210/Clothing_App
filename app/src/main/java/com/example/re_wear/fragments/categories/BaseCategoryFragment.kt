package com.example.re_wear.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.re_wear.R
import com.example.re_wear.adapters.BestProductsAdapter
import com.example.re_wear.adapters.SpecialProductsAdapter
import com.example.re_wear.databinding.FragmentBaseCategoryBinding

open class BaseCategoryFragment : Fragment(R.layout.fragment_base_category) {

    private lateinit var binding : FragmentBaseCategoryBinding
    private lateinit var offerAdapter: BestProductsAdapter
    private lateinit var bestProducts: BestProductsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseCategoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}