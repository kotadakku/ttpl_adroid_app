package com.example.ttplapp.features.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ttplapp.features.presentation.home.components.*

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.DashboardScreen.route
    ) {
        composable(route = Screen.DashboardScreen.route) {
            DashboardScreen(navController = navController)
        }
        composable(route = Screen.ClientsScreen.route) {
            ClientsScreen(navController = navController)
        }
        composable(route = Screen.UsersScreen.route) {
            UsersScreen(navController = navController)
        }
        composable(route = Screen.ProjectsScreen.route) {
            ProjectsScreen(navController = navController)
        }
    }
}