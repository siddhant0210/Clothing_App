package com.example.re_wear.fragments.categories

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.re_wear.R
import com.example.re_wear.adapters.SpecialProductsAdapter
import com.example.re_wear.api.ApiInterface
import com.example.re_wear.data.SpecialProductsItems
import com.example.re_wear.databinding.FragmentMainCategoryBinding
import com.example.re_wear.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainCategoryFragment : Fragment(R.layout.fragment_main_category) {
    private lateinit var binding: FragmentMainCategoryBinding
    private lateinit var specialProductsAdapter : SpecialProductsAdapter
    private lateinit var rvMain:RecyclerView

    var BASE_URL = "https://api.escuelajs.co"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainCategoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMain=view.findViewById(R.id.specialProducts)
        rvMain.layoutManager = LinearLayoutManager(requireContext())
        setupSpecialProductsRv()
    }

    private fun setupSpecialProductsRv() {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var retroData = retrofit.getData(0, 10)

        // now call back either response or failure

        retroData.enqueue(object : Callback<List<SpecialProductsItems>>{
            override fun onResponse(
                call: Call<List<SpecialProductsItems>>,
                response: Response<List<SpecialProductsItems>>
            ) {
                var data = response.body()!!
                specialProductsAdapter = SpecialProductsAdapter(requireContext() ,data)
                rvMain.adapter = specialProductsAdapter
            }

            override fun onFailure(call: Call<List<SpecialProductsItems>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }
}