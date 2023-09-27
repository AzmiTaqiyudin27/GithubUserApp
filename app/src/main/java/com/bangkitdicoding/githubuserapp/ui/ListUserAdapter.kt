package com.bangkitdicoding.githubuserapp.ui


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangkitdicoding.githubuserapp.data.response.ItemsItem
import com.bangkitdicoding.githubuserapp.databinding.ItemUserBinding
import com.bumptech.glide.Glide

class ListUserAdapter: ListAdapter <ItemsItem, ListUserAdapter.MyViewHolder>(DIFF_CALLBACK) {
    class MyViewHolder(private val binding: ItemUserBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(Item: ItemsItem){
            binding.apply {
                Glide.with(itemView.context)
                    .load(Item.avatarUrl)
                    .circleCrop()
                    .into(imgItemPhoto)
                tvItemName.text = Item.login
                itemView.setOnClickListener{
                        val intentDetail = Intent(itemView.context, DetailActivity::class.java)
                        intentDetail.putExtra( DetailActivity.USERNAME, Item.login)
                        itemView.context.startActivity(intentDetail)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemsItem>(){
            override fun areItemsTheSame(
                oldItem: ItemsItem,
                newItem: ItemsItem
            ): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(
                oldItem: ItemsItem,
                newItem: ItemsItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}