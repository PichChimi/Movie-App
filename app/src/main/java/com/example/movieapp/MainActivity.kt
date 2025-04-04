package com.example.movieapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.moduls.download.DownloadFragment
import com.example.movieapp.moduls.home.HomeFragment
import com.example.movieapp.moduls.profile.ProfileFragment
import com.example.movieapp.moduls.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        onInitBottomNavigationBar()
    }
    fun onInitBottomNavigationBar(){
        setFragment(HomeFragment(this))
        binding.bottomNavigationBar.onItemSelected = { id ->
            when(id){
                0 -> setFragment(HomeFragment(this))
                1 -> setFragment(SearchFragment())
                2 -> setFragment(DownloadFragment())
                3 -> setFragment(ProfileFragment())
            }
        }
    }

    fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView,fragment)
            commitNow()
        }
    }
}