package com.bangkitdicoding.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkitdicoding.data.remote.response.DetailUserResponse
import com.bangkitdicoding.data.remote.response.ItemsItem
import com.bangkitdicoding.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel:  ViewModel() {

    private val _username = MutableLiveData<DetailUserResponse>()
    val username: LiveData<DetailUserResponse> = _username

    private val _followers = MutableLiveData<List<ItemsItem>>()
    val followers: LiveData<List<ItemsItem>> = _followers

    private val _following = MutableLiveData<List<ItemsItem>>()
    val following: LiveData<List<ItemsItem>> = _following

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getDetail(user:String) {
        _isLoading.value = true
        val client = ApiConfig.getApiServices().getDetailUser(user)
        client.enqueue(object : Callback<DetailUserResponse> {
            override fun onResponse(
                call: Call<DetailUserResponse>,
                response: Response<DetailUserResponse>
            ){
                _isLoading.value = false
                if (response.isSuccessful){
                    _username.value = response.body()
                } else {
                    Log.e(DetailActivity.TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailUserResponse>, t: Throwable){
                _isLoading.value = false
                Log.e(DetailActivity.TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun getFollowers (user: String) {
        _isLoading.value = true
        val client = ApiConfig.getApiServices().getFollowers(user)
        client.enqueue(object : Callback<List<ItemsItem>> {
            override fun onResponse(
                call: Call<List<ItemsItem>>,
                response: Response<List<ItemsItem>>
            ) {
                _isLoading.value = false
                if (response.isSuccessful){
                    _followers.value = response.body()
                } else {
                    Log.e(DetailActivity.TAG, "onFailure ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<ItemsItem>>, t: Throwable) {
                _isLoading.value = false
                Log.e(DetailActivity.TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun getFollowing (user: String) {
        _isLoading.value = true
        val client = ApiConfig.getApiServices().getFollowing(user)
        client.enqueue(object  : Callback<List<ItemsItem>>{
            override fun onResponse(
                call: Call<List<ItemsItem>>,
                response: Response<List<ItemsItem>>
            ) {
                _isLoading.value = false
                if (response.isSuccessful){
                    _following.value = response.body()
                } else {
                    Log.e(DetailActivity.TAG, "onFailure ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<ItemsItem>>, t: Throwable) {
                _isLoading.value = false
                Log.e(DetailActivity.TAG, "onFailure: ${t.message}")
            }
        })
    }
}
