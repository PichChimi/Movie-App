package com.example.movieapp.moduls.home

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.moduls.home.adapter.CarouselAdapter
import com.example.movieapp.moduls.home.model.CarouselModel
import com.example.movieapp.moduls.home.adapter.CategoryAdapter
import com.example.movieapp.moduls.home.adapter.PopularAdapter
import com.example.movieapp.moduls.home.model.Popular
import kotlin.math.abs

class HomeFragment(private val activity: Activity) : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        onInitCarouselAdapter()
        setUpTransformer()
        onInitCategory()
        onInitPopular()
    }

    fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.8f + r * 0.2f
        }

        binding.carousel.setPageTransformer(transformer)
        binding.indicator.attachTo(binding.carousel)

    }

    fun onInitCarouselAdapter() {
        val list = arrayListOf(
            CarouselModel("Black Panther: Wakanda Forever", "On March 2, 2022", R.drawable.slider1),
            CarouselModel("Black Panther: Wakanda Forever", "On March 2, 2022", R.drawable.slider2),
            CarouselModel("Black Panther: Wakanda Forever", "On March 2, 2022", R.drawable.slider1),
        )

        val carouselAdapter = CarouselAdapter(list)
        binding.carousel.adapter = carouselAdapter
        binding.carousel.offscreenPageLimit = 3
        binding.carousel.clipToPadding = false
        binding.carousel.clipChildren = false
        binding.carousel.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }

    fun onInitCategory() {
        val list = arrayListOf(
            "All",
            "Comedy",
            "Animation",
            "Documentary",
            "Story",
            "Lesson"
        )

        val listener: () -> Unit = {
            // your code
        }

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val categoryAdapter = CategoryAdapter(list, activity, listener)
        binding.recyclerviewCategories.layoutManager = layoutManager
        binding.recyclerviewCategories.adapter = categoryAdapter

    }

    fun onInitPopular(){
        val list = arrayListOf(
            Popular(R.drawable.spiderman,"Spider-Man No..",4.5f),
            Popular(R.drawable.life,"Life Of Pi",3.5f),
            Popular(R.drawable.ungle,"Riverdale",2.5f)
        )

        val layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        val adapterPopular = PopularAdapter(list)
        binding.rycyclerViewPopular.layoutManager = layoutManager
        binding.rycyclerViewPopular.adapter = adapterPopular
    }


}
