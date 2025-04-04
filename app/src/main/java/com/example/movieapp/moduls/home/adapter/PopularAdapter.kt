package com.example.movieapp.moduls.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemPopularLayoutBinding
import com.example.movieapp.moduls.home.model.Popular

class PopularAdapter(private val list: ArrayList<Popular>): RecyclerView.Adapter<PopularAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPopularLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_popular_layout,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.onBind(currentItem)
    }

    inner class ViewHolder(private val binding: ItemPopularLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Popular){
            binding.pImage.setImageResource(item.image)
            binding.pTitle.text = item.title
            binding.pStar.text = item.star.toString()
        }
    }
}