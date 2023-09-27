package com.bangkitdicoding.githubuserapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkitdicoding.githubuserapp.data.response.ItemsItem
import com.bangkitdicoding.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listViewModel by viewModels<ListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        listViewModel.user.observe(this) { user ->
            setUserData(user)
        }

        val layoutManager = LinearLayoutManager(this)
        binding.rvUser.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvUser.addItemDecoration(itemDecoration)

        listViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        binding.apply {
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener{ textView, actionId, event ->
                searchBar.text = searchView.text
                searchView.hide()
                listViewModel.getList(searchView.text.toString())
                false

            }
            }

    }
    private fun showLoading(state: Boolean) {
        binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE }

    private fun setUserData(user: List<ItemsItem?>?) {
        val adapter = ListUserAdapter()
        adapter.submitList(user)
        binding.rvUser.adapter = adapter
    }

}