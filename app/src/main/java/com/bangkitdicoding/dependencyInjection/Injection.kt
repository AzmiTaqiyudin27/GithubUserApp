package com.bangkitdicoding.dependencyInjection

import android.content.Context
import com.bangkitdicoding.data.RepositoryUser
import com.bangkitdicoding.data.local.Room.DatabaseUser
import com.bangkitdicoding.utils.SettingPreferences
import com.bangkitdicoding.utils.dataStore
import com.bangkitdicoding.utils.AppExecutors

object Injection {
    fun provoideRepository(context: Context) : RepositoryUser {
        val database = DatabaseUser.getInstance(context)
        val dao = database.daoUser()
        val appExecutors = AppExecutors()
        val settingPreferences = SettingPreferences.getInstance(context.dataStore)
        return RepositoryUser.getInstance(dao, appExecutors, settingPreferences)

    }
}