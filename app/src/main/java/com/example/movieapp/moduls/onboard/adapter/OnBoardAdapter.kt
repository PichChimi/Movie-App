package com.example.movieapp.moduls.onboard.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardAdapter(private val fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    private val titleOnBoard: ArrayList<String> = ArrayList()
    private val desOnBoard: ArrayList<String> = ArrayList()

    fun addFragment(fragment: Fragment, title: String, des: String) {
        fragmentList.add(fragment)
        titleOnBoard.add(title)
        desOnBoard.add(des)
    }

    fun getTitleOnBoard(position: Int): String = titleOnBoard[position]

    fun getDesOnBoard(position: Int): String = desOnBoard[position]

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}