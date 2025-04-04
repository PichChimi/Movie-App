package com.example.movieapp.moduls.onboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.movieapp.LoginAndSignUpActivity
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainOnboardBinding
import com.example.movieapp.moduls.onboard.adapter.OnBoardAdapter
import com.example.movieapp.moduls.onboard.fragment.OnboardV1Fragment
import com.example.movieapp.moduls.onboard.fragment.OnboardV2Fragment
import com.example.movieapp.moduls.onboard.fragment.OnboardV3Fragment

class MainOnboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainOnboardBinding
    private lateinit var onboardAdapter: OnBoardAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main_onboard)
        binding =
            DataBindingUtil.setContentView(this@MainOnboardActivity, R.layout.activity_main_onboard)

        onInitMainOnboardAdapter()
    }

    private fun onInitMainOnboardAdapter() {
        onboardAdapter = OnBoardAdapter(fragmentActivity = this@MainOnboardActivity)
        onboardAdapter.addFragment(
            fragment = OnboardV1Fragment(),
            title = resources.getString(R.string.TitleOnboardV1),
            des = resources.getString(R.string.DescriptionOnboardV1)
        )
        onboardAdapter.addFragment(
            fragment = OnboardV2Fragment(),
            title = resources.getString(R.string.TitleOnboardV2),
            des = resources.getString(R.string.DescriptionOnboardV2)
        )
        onboardAdapter.addFragment(
            fragment = OnboardV3Fragment(),
            title = resources.getString(R.string.TitleOnboardV3),
            des = resources.getString(R.string.DescriptionOnboardV3)
        )

        binding.viewPagerB.adapter = onboardAdapter
        binding.indicator.attachTo(binding.viewPagerB)

        binding.viewPagerB.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val title = onboardAdapter.getTitleOnBoard(position)
                val des = onboardAdapter.getDesOnBoard(position)

                binding.txtTitleOnboard.text = title
                binding.txtDesOnboard.text = des
            }
        })

        binding.btnNextBoard.setOnClickListener {
            val currentOnboardPosition = binding.viewPagerB.currentItem
            if(currentOnboardPosition == 2){
                startActivity(Intent(this, LoginAndSignUpActivity::class.java))
            }else{
                binding.viewPagerB.currentItem = (currentOnboardPosition+1)
            }
        }
    }


}