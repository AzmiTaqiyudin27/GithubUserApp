package com.bangkitdicoding.data.local.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bangkitdicoding.data.local.Entity.FavoriteUser

@Dao
interface DaoUser {

    @Query("SELECT * FROM FavoriteUser ORDER BY username ASC")
    fun getAllUsers(): LiveData<List<FavoriteUser>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(favoriteUser: FavoriteUser)

    @Query("SELECT * FROM FavoriteUser WHERE username= :username")
    fun getUserByUsername(username: String): LiveData<FavoriteUser>
    @Delete
    fun delete(user: FavoriteUser)
}