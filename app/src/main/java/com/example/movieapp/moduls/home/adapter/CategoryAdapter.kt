package com.example.movieapp.moduls.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemCategoryLayoutBinding

class CategoryAdapter(private val list: List<String>,private val context: Context,private val callback:() -> Unit): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var currentPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding: ItemCategoryLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
           R.layout.item_category_layout,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position],position)
    }

    inner class ViewHolder(private val binding: ItemCategoryLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(item: String,position: Int){
           binding.title.text = item
            binding.title.setOnClickListener {
                currentPosition = position
                callback.invoke()
                notifyDataSetChanged()
            }
            if(currentPosition == position){
                binding.title.setTextColor(ContextCompat.getColor(context,R.color.sky))
                binding.title.background = ContextCompat.getDrawable(context,R.drawable.bg_category)
            }else{
               binding.title.setTextColor(ContextCompat.getColor(context,R.color.white))
                binding.title.background = null
            }
        }
    }
}