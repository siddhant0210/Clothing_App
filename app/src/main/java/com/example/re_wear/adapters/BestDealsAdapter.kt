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

class BestDealsAdapter(private var con: Context, private var list: List<SpecialProductsItems>) :
    RecyclerView.Adapter<BestDealsAdapter.BestDealsViewHolder>() {

    inner class BestDealsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val img: ImageView = v.findViewById(R.id.img_best_deal)
        val nam: TextView = v.findViewById(R.id.tv_deal_product_name)
        val price: TextView = v.findViewById(R.id.tv_old_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestDealsViewHolder {
        val view = LayoutInflater.from(con).inflate(R.layout.best_deals_rv_item, parent, false)
        return BestDealsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: BestDealsViewHolder, position: Int) {
//        val firstImageUrl = list[position].image.getOrNull(0)
////        val imagesArray =  JSONArray(firstImageUrl)
//
//
//        // Handle potential null cases gracefully
//        if (firstImageUrl != null) {
//            // Load the first image using Glide
//            Glide.with(con).load(firstImageUrl).into(holder.img)
//        } else {
//            // Set a placeholder image or handle the missing image case as needed
//            holder.img.setImageResource(R.drawable.baseline_downloading_24) // Replace with your placeholder
//        }
        Glide.with(con).load(list[position].image).into(holder.img)
        holder.nam.text = list[position].title
        holder.price.text = list[position].price.toString()
    }
}
