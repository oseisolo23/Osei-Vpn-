package com.oseisolo.oseivpn.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oseisolo.oseivpn.ui.screens.DashboardScreen
import com.oseisolo.oseivpn.ui.screens.ServerListScreen
import com.oseisolo.oseivpn.ui.screens.StatisticsScreen
import com.oseisolo.oseivpn.ui.screens.SettingsScreen

/**
 * Navigation routes for Osei VPN
 */
object NavRoutes {
    const val DASHBOARD = "dashboard"
    const val SERVERS = "servers"
    const val STATISTICS = "statistics"
    const val SETTINGS = "settings"
}

/**
 * Osei VPN Navigation Graph
 * 
 * Handles navigation between different screens in the application
 */
@Composable
fun OseiVpnApp() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = NavRoutes.DASHBOARD
    ) {
        composable(NavRoutes.DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(NavRoutes.SERVERS) {
            ServerListScreen(navController)
        }
        composable(NavRoutes.STATISTICS) {
            StatisticsScreen(navController)
        }
        composable(NavRoutes.SETTINGS) {
            SettingsScreen(navController)
        }
    }
}
