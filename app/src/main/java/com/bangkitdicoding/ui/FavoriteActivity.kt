package com.bangkitdicoding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkitdicoding.githubuserapp.databinding.ActivityFavoriteBinding
import com.bangkitdicoding.utils.ViewModelFactory

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModels { ViewModelFactory.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        favoriteViewModel.getAllUsers().observe(this@FavoriteActivity){
            val favoriteAdapter = FavoriteAdapter()
            favoriteAdapter.submitList(it)
            binding.apply {
                rvFavorite.layoutManager = LinearLayoutManager(this@FavoriteActivity)
                rvFavorite.adapter = favoriteAdapter
            }
        }
    }
}