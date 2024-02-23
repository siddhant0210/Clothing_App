package com.example.re_wear.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.re_wear.R
import com.example.re_wear.data.SpecialProductsItems
import org.json.JSONArray

class ProductsAdapter(private var con : Context, private var list : List<SpecialProductsItems>) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    inner class ProductsViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val img : ImageView = v.findViewById(R.id.img_product)
        val nam : TextView = v.findViewById(R.id.tv_name)
        val price : TextView = v.findViewById(R.id.tv_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(con).inflate(R.layout.product_rv_item , parent, false)
        return  ProductsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
//        val firstImageUrl = list[position].image.getOrNull(0)
//
//
//        if (firstImageUrl != null) {
//
//            // Load the first image using Glide
//            Glide.with(holder.img).load(firstImageUrl.get(0)).into(holder.img)
//        } else {
//            // Set a placeholder image or handle the missing image case as needed
//            holder.img.setImageResource(R.drawable.baseline_downloading_24) // Replace with your placeholder
//        }
        Glide.with(con).load(list[position].image).into(holder.img)

        holder.nam.text = list[position].title
        holder.price.text = list[position].price.toString()
    }
}