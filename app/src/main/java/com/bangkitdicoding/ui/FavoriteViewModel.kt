package com.bangkitdicoding.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkitdicoding.data.RepositoryUser
import com.bangkitdicoding.data.local.Entity.FavoriteUser

class FavoriteViewModel(private val repositoryUser: RepositoryUser) : ViewModel() {

    fun getAllUsers() : LiveData<List<FavoriteUser>> = repositoryUser.getAllUsers()

    fun getFavoriteUserByUsername(username: String) : LiveData<FavoriteUser> = repositoryUser.getFavoriteUserByUsername(username)

    fun addFavorite(favoriteUser: FavoriteUser) {
        repositoryUser.addFavorite(favoriteUser)
    }

    fun delete(favoriteUser: FavoriteUser) {
        repositoryUser.delete(favoriteUser)
    }
}