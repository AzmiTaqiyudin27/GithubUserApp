package com.bangkitdicoding.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkitdicoding.data.remote.response.ItemsItem
import com.bangkitdicoding.githubuserapp.databinding.ItemUserBinding
import com.bangkitdicoding.utils.loadImage

class ListFollowAdapter (private val listUser: List<ItemsItem>) :
    RecyclerView.Adapter<ListFollowAdapter.MyViewHolder>(){

    class MyViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ItemsItem){
            binding.apply {
                imgItemPhoto.loadImage(item.avatarUrl)
                tvItemName.text = item.login
                itemView.setOnClickListener{
                    val intentDetail = Intent(itemView.context, DetailActivity::class.java)
                    intentDetail.putExtra(DetailActivity.USERNAME, item.login)
                    itemView.context.startActivity(intentDetail)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int =listUser.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

}