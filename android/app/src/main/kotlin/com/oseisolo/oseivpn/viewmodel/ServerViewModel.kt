package com.oseisolo.oseivpn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oseisolo.oseivpn.data.local.ServerEntity
import com.oseisolo.oseivpn.repository.ServerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServerViewModel @Inject constructor(
    private val repository: ServerRepository
) : ViewModel() {

    val servers: StateFlow<List<ServerEntity>> = repository.getAllServers()
        .map { it }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val favorites: StateFlow<List<ServerEntity>> = repository.getFavoriteServers()
        .map { it }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun refresh() {
        viewModelScope.launch {
            repository.refreshFromRemote()
        }
    }
}
