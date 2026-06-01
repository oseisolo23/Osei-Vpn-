package com.oseisolo.oseivpn.service

/**
 * Protocol adapter interfaces - implement these to support actual protocols
 */
interface ProtocolAdapter {
    suspend fun establish(config: VpnConfig): Boolean
    suspend fun teardown()
}

// Example placeholder adapter
class WireGuardAdapter : ProtocolAdapter {
    override suspend fun establish(config: VpnConfig): Boolean {
        // TODO: integrate WireGuard userspace or use a native wrapper
        return false
    }

    override suspend fun teardown() {
        // TODO
    }
}
