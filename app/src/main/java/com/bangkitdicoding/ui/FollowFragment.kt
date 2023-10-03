package com.bangkitdicoding.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkitdicoding.data.remote.response.ItemsItem
import com.bangkitdicoding.githubuserapp.databinding.FragmentFollowBinding


class FollowFragment : Fragment() {

    private lateinit var binding: FragmentFollowBinding
    private val detailViewModel by viewModels<DetailViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val position = it.getInt(ARG_POSITION)
            val username = it.getString(ARG_USERNAME)
            detailViewModel.getFollowers(username.toString())
            detailViewModel.getFollowing(username.toString())
            detailViewModel.isLoading.observe(viewLifecycleOwner) {showLoading(it)}
            if (position == 1) {
                detailViewModel.followers.observe(viewLifecycleOwner) {setList(it)}
            } else {
                detailViewModel.following.observe(viewLifecycleOwner) {setList(it)}
            }
        }
    }

    fun setList(item: List<ItemsItem>){
        val  listUser = ListFollowAdapter(item)
        binding.follow.layoutManager = LinearLayoutManager(requireActivity())
        binding.follow.adapter = listUser
    }

    private fun showLoading(state: Boolean) { binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE }

    companion object {
        const val ARG_POSITION = "position"
        const val ARG_USERNAME = "USERNAME"
    }
}