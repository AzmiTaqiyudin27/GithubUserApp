package com.bangkitdicoding.githubuserapp.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bangkitdicoding.githubuserapp.R
import com.bangkitdicoding.githubuserapp.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val user = intent.getStringExtra(USERNAME)

        detailViewModel.getDetail(user.toString())

        detailViewModel.username.observe(this) {
            Glide.with(this@DetailActivity)
            .load(it!!.avatarUrl)
            .circleCrop()
            .into(binding.photo)
            binding.fullname.text = it!!.name
            binding.username.text = it!!.login
            val sectionPagerAdapter = SectionPagerAdapter(this)
            sectionPagerAdapter.username = user.toString()
            binding.viewPager.adapter = sectionPagerAdapter
            val tabs : TabLayout = findViewById(R.id.tabs)
            val follow = mutableListOf<String>(
                    String.format(getString(R.string.Followers,it!!.followers)),
                    String.format(getString(R.string.Following,it!!.following))
            )
            TabLayoutMediator(tabs, binding.viewPager) { tab, position ->
                tab.text = follow[position]
            }.attach()
            supportActionBar?.elevation = 0f
        }
        detailViewModel.isLoading.observe(this) {
            showLoading(it)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading){
            binding.progressBar.visibility = View.VISIBLE
        } else{
            binding.progressBar.visibility = View.GONE
        }
    }

    companion object{
        const val USERNAME = "AzmiTaqiyudin27"
        const val TAG = "DetailActivity"
    }

}
