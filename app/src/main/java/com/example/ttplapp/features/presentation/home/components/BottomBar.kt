package com.example.ttplapp.features.presentation.home.components

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ttplapp.ui.theme.Orange
import com.example.ttplapp.R

@Composable
fun BottomBar(navController: NavHostController){
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Clients,
        NavigationItem.Users,
        NavigationItem.Projects,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Box(modifier = Modifier.fillMaxWidth()){
        BottomAppBar(
            backgroundColor = Color.White,
            cutoutShape = CircleShape,
            elevation =  20.dp,
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))

        ) {
            items.forEachIndexed { index, item ->
                if (index == 2) {
                    // add an empty space for FAB
                    BottomNavigationItem(
                        selected = false,
                        onClick = {},
                        icon = {},
                        enabled = false
                    )
                }
                // adding each item
                BottomNavigationItem(
                    selectedContentColor = Orange,
                    unselectedContentColor = Color.Gray,
                    selected = (currentRoute == item.route),
                    onClick = {
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                        )
                    },
                    label = {
                        Text(text = item.title)
                    },
                    alwaysShowLabel = false,
                    enabled = true
                )
            }
        }
    }
}


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("dashboard", R.drawable.ic_home, "Home")
    object Clients : NavigationItem("clients", R.drawable.ic_user, "Clients")
    object Users : NavigationItem("users", R.drawable.ic_users, "Users")
    object Projects : NavigationItem("projects", R.drawable.ic_briefcase, "Projects")
}