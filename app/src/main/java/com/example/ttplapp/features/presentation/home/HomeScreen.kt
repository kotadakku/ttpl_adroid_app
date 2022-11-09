package com.example.ttplapp.features.presentation.home.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ttplapp.ui.theme.BackgroundNeutral
import com.example.ttplapp.ui.theme.Content3
import com.example.ttplapp.ui.theme.Orange
import kotlinx.coroutines.launch
import com.example.ttplapp.features.presentation.Navigation


@Composable
fun HomeScreen(
){
    val scaffoldState = rememberScaffoldState()

    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("example", TextRange(0, 7)))
    }
    Scaffold(
        drawerContent = {
            DrawerComponent()
            // Drawer items
        },
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        placeholder = {
                            Text("Search",
                                fontSize = 16.sp,
                                color = Content3,

                                )
                        },
                        trailingIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = null
                                )
                            }
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = BackgroundNeutral,
                            focusedIndicatorColor =  Color.Transparent, //hide the indicator
                            unfocusedIndicatorColor = BackgroundNeutral
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                },
                actions = {
                    // RowScope here, so these icons will be placed horizontally
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Localized description")
                    }
                },
                backgroundColor = Color.White,
                elevation = 10.dp,

                )
        },
        bottomBar = { BottomBar(navController = navController) },
        floatingActionButton = {
            FloatingActionButton(onClick = {},
                backgroundColor = Orange
            ) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        scaffoldState = scaffoldState,
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        content = {
            padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        }
    )

}