package com.oseisolo.oseivpn.repository

import com.oseisolo.oseivpn.data.local.ServerDao
import com.oseisolo.oseivpn.data.local.ServerEntity
import kotlinx.coroutines.flow.Flow

interface ServerRepository {
    fun getAllServers(): Flow<List<ServerEntity>>
    fun getFavoriteServers(): Flow<List<ServerEntity>>
    suspend fun refreshFromRemote() // placeholder for network sync
}

class ServerRepositoryImpl(private val dao: ServerDao) : ServerRepository {
    override fun getAllServers(): Flow<List<ServerEntity>> = dao.getAll()
    override fun getFavoriteServers(): Flow<List<ServerEntity>> = dao.getFavorites()

    override suspend fun refreshFromRemote() {
        // TODO: Implement network call to fetch servers and insert into DB
        // This is a placeholder that should be replaced with Retrofit/OkHttp integration
    }
}
