package com.oseisolo.oseivpn.service

import android.app.Service
import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * OseiVpnService - skeleton VpnService implementation
 * 
 * NOTE: This file provides a safe, non-functional skeleton. Do not include
 * any production credentials or server private keys. Implement protocol
 * adapters (WireGuard/OpenVPN) behind the VpnConnectionManager interfaces.
 */
class OseiVpnService : VpnService() {

    private var vpnInterface: ParcelFileDescriptor? = null
    private val scope = CoroutineScope(Dispatchers.IO + Job())

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Start or stop VPN based on intent actions (CONNECT/DISCONNECT)
        // For safety this skeleton does not establish a real tunnel.
        return Service.START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        vpnInterface?.close()
        scope.cancel()
    }

    override fun onRevoke() {
        super.onRevoke()
        // User revoked VPN permission
        vpnInterface?.close()
    }

    fun buildVpn(): ParcelFileDescriptor? {
        val builder = Builder()
            .setSession("OseiVPN")
            .addAddress("10.0.0.2", 24) // placeholder
            .addDnsServer("8.8.8.8")
            .addRoute("0.0.0.0", 0)
        // Configure MTU, routes, and allowed apps here
        return try {
            builder.establish()
        } catch (e: Exception) {
            null
        }
    }
}
