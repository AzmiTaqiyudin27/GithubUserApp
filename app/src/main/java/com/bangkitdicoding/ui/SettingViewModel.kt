package com.bangkitdicoding.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bangkitdicoding.data.RepositoryUser
import kotlinx.coroutines.launch

class SettingViewModel (private val repositoryUser: RepositoryUser): ViewModel() {

    fun getThemeSettings(): LiveData<Boolean> {
        return repositoryUser.getThemeSetting().asLiveData()
    }

    fun saveThemeSetting(isDarkModeActive: Boolean) {
        viewModelScope.launch {
            repositoryUser.saveThemeSetting(isDarkModeActive)
        }
    }
}