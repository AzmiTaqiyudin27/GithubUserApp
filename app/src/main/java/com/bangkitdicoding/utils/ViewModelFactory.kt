package com.bangkitdicoding.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkitdicoding.data.RepositoryUser
import com.bangkitdicoding.dependencyInjection.Injection
import com.bangkitdicoding.ui.FavoriteViewModel
import com.bangkitdicoding.ui.SettingViewModel

class ViewModelFactory(private val repositoryUser: RepositoryUser) :
    ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)){
            return  FavoriteViewModel(repositoryUser) as T
        } else if (modelClass.isAssignableFrom(SettingViewModel::class.java)) {
            return SettingViewModel(repositoryUser) as T
        }
        throw IllegalAccessException("Unknown Viewmodel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provoideRepository(context))
            }.also { instance = it }
    }
}