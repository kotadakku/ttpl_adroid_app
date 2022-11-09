package com.example.ttplapp.features.presentation

sealed class Screen(val route: String) {
    object DashboardScreen: Screen("dashboard")
    object ClientsScreen: Screen("clients")
    object UsersScreen: Screen("users")
    object ProjectsScreen: Screen("projects")
}