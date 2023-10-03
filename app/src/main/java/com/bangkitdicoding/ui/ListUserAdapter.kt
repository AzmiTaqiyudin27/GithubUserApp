package com.bangkitdicoding.ui


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangkitdicoding.data.remote.response.ItemsItem
import com.bangkitdicoding.githubuserapp.databinding.ItemUserBinding
import com.bangkitdicoding.utils.loadImage

class ListUserAdapter: ListAdapter <ItemsItem, ListUserAdapter.MyViewHolder>(DIFF_CALLBACK) {
    class MyViewHolder(private val binding: ItemUserBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(Item: ItemsItem){
            binding.apply {
                imgItemPhoto.loadImage(Item.avatarUrl)
                tvItemName.text = Item.login
                itemView.setOnClickListener{
                        val intentDetail = Intent(itemView.context, DetailActivity::class.java)
                        intentDetail.putExtra(DetailActivity.USERNAME, Item.login)
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