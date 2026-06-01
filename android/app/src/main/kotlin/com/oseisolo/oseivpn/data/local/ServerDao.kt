package com.oseisolo.oseivpn.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ServerDao {
    @Query("SELECT * FROM servers")
    fun getAll(): Flow<List<ServerEntity>>

    @Query("SELECT * FROM servers WHERE isFavorite = 1")
    fun getFavorites(): Flow<List<ServerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(servers: List<ServerEntity>)

    @Query("DELETE FROM servers")
    suspend fun clear()
}
