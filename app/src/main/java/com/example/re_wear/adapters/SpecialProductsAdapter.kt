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

class SpecialProductsAdapter (private var con : Context, private var list: List<SpecialProductsItems>):
    RecyclerView.Adapter<SpecialProductsAdapter.SpecialProductsViewHolder>() {
    // Diff util helps to make recycler view faster by just updating the item that get updated and not all the items
    inner class SpecialProductsViewHolder(v : View) : RecyclerView.ViewHolder(v) {
       var img: ImageView = v.findViewById<ImageView>(R.id.image_special_rv_item)
        var nam: TextView = v.findViewById<TextView>(R.id.tbSpecialProductName)
        var price: TextView = v.findViewById<TextView>(R.id.tvSpecialProductPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialProductsViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.special_rv_item,parent,false)
        return SpecialProductsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: SpecialProductsViewHolder, position: Int) {
        // konsi cheez khaa rkhni hai
        Glide.with(con).load(list[position].image).into(holder.img)
        holder.nam.text = list[position].title
        holder.price.text = list[position].price.toString()
    }


}