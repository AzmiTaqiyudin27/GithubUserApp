package com.bangkitdicoding.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangkitdicoding.data.local.Entity.FavoriteUser
import com.bangkitdicoding.githubuserapp.databinding.ItemUserBinding
import com.bangkitdicoding.utils.loadImage

class FavoriteAdapter: ListAdapter <FavoriteUser, FavoriteAdapter.MyViewHolder>(DIFF_CALLBACK){
    class MyViewHolder (private val binding: ItemUserBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FavoriteUser){
            binding.apply {
                imgItemPhoto.loadImage(item.avatarUrl)
                tvItemName.text = item.username
                itemView.setOnClickListener{
                    val intentDetail = Intent(itemView.context, DetailActivity::class.java)
                    intentDetail.putExtra(DetailActivity.USERNAME, item.username)
                    itemView.context.startActivity(intentDetail)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return FavoriteAdapter.MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FavoriteUser>(){
            override fun areItemsTheSame(
                oldItem: FavoriteUser,
                newItem: FavoriteUser
            ): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(
                oldItem: FavoriteUser,
                newItem: FavoriteUser
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
