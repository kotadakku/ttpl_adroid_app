package com.example.ttplapp.features.presentation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home")
}