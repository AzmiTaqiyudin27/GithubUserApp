package com.bangkitdicoding.data.local.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangkitdicoding.data.local.Entity.FavoriteUser

@Database(entities = [FavoriteUser::class], version = 1)
abstract class DatabaseUser :RoomDatabase() {
    abstract fun daoUser(): DaoUser

    companion object{
        @Volatile
        private var INSTANCE: DatabaseUser? = null

        @JvmStatic
        fun getInstance(context: Context): DatabaseUser =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseUser::class.java, "FavoriteUser.db"
                ).build()
            }
    }
}