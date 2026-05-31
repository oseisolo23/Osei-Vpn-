package com.oseisolo.oseivpn.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.oseisolo.oseivpn.ui.components.ConnectButton
import com.oseisolo.oseivpn.ui.components.GlassmorphicCard
import com.oseisolo.oseivpn.ui.components.StatisticCard
import com.oseisolo.oseivpn.ui.navigation.NavRoutes

/**
 * Dashboard Screen - Main VPN connection interface
 * 
 * Displays:
 * - VPN connection status
 * - Connect/Disconnect button
 * - Connection statistics (speed, duration, IP)
 * - Server information
 * - Quick access to other screens
 */
@Composable
fun DashboardScreen(navController: NavHostController) {
    var isConnected by remember { mutableStateOf(false) }
    var connectionTime by remember { mutableStateOf(0L) }
    var downloadSpeed by remember { mutableStateOf("0.00 Mbps") }
    var uploadSpeed by remember { mutableStateOf("0.00 Mbps") }
    var selectedServer by remember { mutableStateOf("Ghana 2") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color(0xFFA78BFA)
                )
            }
            
            Text(
                "Osei VPN",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF8FAFC)
            )
            
            Button(
                onClick = { navController.navigate(NavRoutes.SETTINGS) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF7C3AED),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.height(40.dp)
            ) {
                Text("ADD TIME", fontWeight = FontWeight.Bold)
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Main Connect Button with Glassmorphism
        GlassmorphicCard(
            modifier = Modifier.size(280.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    selectedServer,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF06B6D4)
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                ConnectButton(
                    isConnected = isConnected,
                    onClick = { isConnected = !isConnected }
                )
                
                Spacer(modifier = Modifier.height(20.dp))
                
                Text(
                    if (isConnected) "CONNECTED" else "DISCONNECTED",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (isConnected) Color(0xFF10B981) else Color(0xFFEF4444)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Statistics Section
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatisticCard(
                title = "Download",
                value = downloadSpeed,
                modifier = Modifier.weight(1f)
            )
            StatisticCard(
                title = "Upload",
                value = uploadSpeed,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatisticCard(
                title = "Duration",
                value = "${connectionTime}s",
                modifier = Modifier.weight(1f)
            )
            StatisticCard(
                title = "Ping",
                value = "--",
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Navigation Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = { navController.navigate(NavRoutes.SERVERS) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF7C3AED),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Servers", fontWeight = FontWeight.Bold)
            }
            
            Button(
                onClick = { navController.navigate(NavRoutes.STATISTICS) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF06B6D4),
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Stats", fontWeight = FontWeight.Bold)
            }
        }
    }
}
