package com.example.re_wear.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.re_wear.R
import com.example.re_wear.adapters.BestDealsAdapter
import com.example.re_wear.adapters.ProductsAdapter
import com.example.re_wear.adapters.SpecialProductsAdapter
import com.example.re_wear.api.ApiInterface
import com.example.re_wear.data.SpecialProductsItems
import com.example.re_wear.databinding.FragmentMainCategoryBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainCategoryFragment : Fragment(R.layout.fragment_main_category) {
    private lateinit var binding: FragmentMainCategoryBinding
    private lateinit var specialProductsAdapter: SpecialProductsAdapter
    private lateinit var rvMain: RecyclerView
    private lateinit var bestDealsAdapter: BestDealsAdapter
    private lateinit var deals: RecyclerView
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var products: RecyclerView


    private var BASE_URL = "https://fakestoreapi.com"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainCategoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMain = view.findViewById(R.id.specialProducts)
        rvMain.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        setupSpecialProductsRv()  // for special products

        deals = view.findViewById(R.id.bestDeals)
        deals.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        setupBestProductsRv() // for best deals

        products = view.findViewById(R.id.bestProducts)
        products.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        setupProductsRv() // for All products
    }

    fun getAPIInterface(): ApiInterface {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(
                OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build()
            ).build().create(ApiInterface::class.java)
    }


    private fun setupSpecialProductsRv() {
        val retrofit = getAPIInterface()

        val retroData = retrofit.getData(0, 10)

        // now call back either response or failure

        retroData.enqueue(object : Callback<List<SpecialProductsItems>> {
            override fun onResponse(
                call: Call<List<SpecialProductsItems>>,
                response: Response<List<SpecialProductsItems>>
            ) {
                val data = response.body()!!
                specialProductsAdapter = SpecialProductsAdapter(requireContext(), data)
                rvMain.adapter = specialProductsAdapter
            }

            override fun onFailure(call: Call<List<SpecialProductsItems>>, t: Throwable) {
                /// TODO("Not yet implemented")
            }

        })
    }

    // BEST DEALS SEGMENT START FROM HERE ------------------>

    private fun setupBestProductsRv() {
        val retrofit = getAPIInterface()

        val retroData = retrofit.getDeal(5, 15)

        // now call back either response or failure

        retroData.enqueue(object : Callback<List<SpecialProductsItems>> {
            override fun onResponse(
                call: Call<List<SpecialProductsItems>>,
                response: Response<List<SpecialProductsItems>>
            ) {
                val data = response.body()!!
                bestDealsAdapter = BestDealsAdapter(requireContext(), data)
                deals.adapter = bestDealsAdapter
            }

            override fun onFailure(call: Call<List<SpecialProductsItems>>, t: Throwable) {
                // TODO("Not yet implemented")
            }
        })
    }

    // PRODUCTS SEGMENT START HERE ---------------->
    private fun setupProductsRv() {
        val retrofit = getAPIInterface()
        val retroData = retrofit.getProduct(0, 10)

        retroData.enqueue(object : Callback<List<SpecialProductsItems>> {
            override fun onResponse(
                call: Call<List<SpecialProductsItems>>,
                response: Response<List<SpecialProductsItems>>
            ) {
                val data = response.body()!!
                productsAdapter = ProductsAdapter(requireContext(), data)
                products.adapter = productsAdapter
            }

            override fun onFailure(call: Call<List<SpecialProductsItems>>, t: Throwable) {
                // TODO("Not yet implemented")
            }

        })
    }
}