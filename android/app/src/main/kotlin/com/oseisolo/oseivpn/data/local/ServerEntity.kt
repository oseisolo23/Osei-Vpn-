package com.oseisolo.oseivpn.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "servers")
data class ServerEntity(
    @PrimaryKey val id: String,
    val name: String,
    val country: String,
    val ping: Int,
    val isFavorite: Boolean = false,
    val users: Int = 0,
    val load: Int = 0,
    val speed: String = "High",
    val protocol: String = "WireGuard"
)
