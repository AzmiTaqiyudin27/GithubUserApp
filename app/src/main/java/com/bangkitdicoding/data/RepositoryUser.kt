package com.bangkitdicoding.data

import androidx.lifecycle.LiveData
import com.bangkitdicoding.data.local.Entity.FavoriteUser
import com.bangkitdicoding.data.local.Room.DaoUser
import com.bangkitdicoding.utils.AppExecutors
import com.bangkitdicoding.utils.SettingPreferences
import kotlinx.coroutines.flow.Flow

class RepositoryUser (
    private val daoUser: DaoUser,
    private val appExecutors: AppExecutors,
    private val settingPreferences: SettingPreferences
    ) {

    fun addFavorite(favoriteUser: FavoriteUser) {
        appExecutors.diskIO.execute{
            daoUser.addUser(favoriteUser)
        }
    }

    fun getAllUsers() : LiveData<List<FavoriteUser>> = daoUser.getAllUsers()

    fun getFavoriteUserByUsername(username: String): LiveData<FavoriteUser> = daoUser.getUserByUsername(username)

    fun delete(favoriteUser: FavoriteUser) {
        appExecutors.diskIO.execute{
            daoUser.delete(favoriteUser)
        }
    }

    fun getThemeSetting(): Flow<Boolean> = settingPreferences.getThemeSetting()

    suspend fun saveThemeSetting(isDarkModeActive: Boolean) = settingPreferences.saveThemeSetting(isDarkModeActive)
    companion object {
        @Volatile
        private var INSTANCE: RepositoryUser? = null

        fun getInstance(
            daoUser: DaoUser,
            appExecutors: AppExecutors,
            settingPreferences: SettingPreferences
        ):RepositoryUser = INSTANCE ?: synchronized(this) {
            INSTANCE ?: RepositoryUser(daoUser,appExecutors, settingPreferences)
        }.also { INSTANCE = it }
    }
}

