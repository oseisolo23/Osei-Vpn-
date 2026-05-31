package com.oseisolo.oseivpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.oseisolo.oseivpn.ui.navigation.OseiVpnApp
import com.oseisolo.oseivpn.ui.theme.OseiVPNTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main Activity - Entry point for Osei VPN application
 * 
 * This activity sets up the Compose UI and initializes the application
 * with the MVVM architecture pattern.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OseiVPNTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF0F172A)),
                    color = Color(0xFF0F172A)
                ) {
                    OseiVpnApp()
                }
            }
        }
    }
}
