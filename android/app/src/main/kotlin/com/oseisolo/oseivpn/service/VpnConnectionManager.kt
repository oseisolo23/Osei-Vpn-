package com.oseisolo.oseivpn.service

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * VpnConnectionManager - manages the lifecycle of a VPN connection
 * Provides an abstraction for protocol adapters (WireGuard, OpenVPN)
 */
class VpnConnectionManager {

    private val scope = CoroutineScope(Dispatchers.IO + Job())

    fun connect(config: VpnConfig, onConnected: () -> Unit = {}, onError: (Throwable) -> Unit = {}) {
        scope.launch {
            // TODO: plug in protocol adapter to establish connection
            // This is a safe placeholder; do not perform real networking here.
            try {
                // simulate connection
                onConnected()
            } catch (t: Throwable) {
                onError(t)
            }
        }
    }

    fun disconnect() {
        scope.launch {
            // TODO: teardown logic
        }
    }
}

data class VpnConfig(
    val serverId: String,
    val endpoint: String,
    val publicKey: String? = null
)
