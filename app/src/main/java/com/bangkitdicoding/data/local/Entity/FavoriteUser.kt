package com.bangkitdicoding.data.local.Entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

    @Parcelize
    @Entity(tableName = "FavoriteUser")
    data class FavoriteUser(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "username")
        var username: String = "",

        @ColumnInfo(name = "avatarUrl")
        var avatarUrl: String =""

    ) : Parcelable




