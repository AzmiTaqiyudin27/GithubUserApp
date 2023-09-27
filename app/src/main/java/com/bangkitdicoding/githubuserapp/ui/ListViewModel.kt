package com.bangkitdicoding.githubuserapp.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkitdicoding.githubuserapp.data.response.GithubResponse
import com.bangkitdicoding.githubuserapp.data.response.ItemsItem
import com.bangkitdicoding.githubuserapp.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel(){

    private val _user = MutableLiveData<List<ItemsItem?>>()
    val user: LiveData<List<ItemsItem?>> = _user

    private val _isLoading =MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    init {
        getList(username)
    }

    fun getList(query:String) {
        _isLoading.value = true
        val client = ApiConfig.getApiServices().getGithub(query)
        client.enqueue(object : Callback<GithubResponse> {
            override fun onResponse(
                call: Call<GithubResponse>,
                response: Response<GithubResponse>
            ){
                _isLoading.value = false
                if (response.isSuccessful){
                    _user.value = response.body()?.items
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<GithubResponse>, t: Throwable){
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }



    companion object {
        private const val TAG = "USERNAME"
        private const val username = "Azmi"
    }
}
