package com.example.ttplapp.features.presentation.home.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ttplapp.BottomBar
import com.example.ttplapp.R
import com.example.ttplapp.ui.theme.BackgroundNeutral
import com.example.ttplapp.ui.theme.Content3
import com.example.ttplapp.ui.theme.DividerColor
import com.example.ttplapp.ui.theme.Orange
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun HomeScreen(
    navController: NavController
){
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val state = rememberLazyListState()
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("example", TextRange(0, 7)))
    }
    Scaffold(
        drawerContent = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 60.dp, 16.dp, 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        Icons.Filled.Home,
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color(0xFFF0AD00))
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(all = 10.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(){
                        Text("Nguyễn Thanh Điệp",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.height(20.dp)
                        )
                        Text("nguyenthanhdiep@gmail.com",
                            fontSize = 12.sp,
                            color= Content3,
                            modifier = Modifier.height(18.dp)
                        )
                    }
                }

            }
            Divider(
                color = DividerColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            )
            Column(

            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp, 8.dp, 8.dp, 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painterResource(R.drawable.ic_briefcase),
                            tint = Color.White,
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(all = 10.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Chăm sóc khách hàng",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.height(20.dp)
                        )
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp, 8.dp, 8.dp, 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painterResource(R.drawable.ic_briefcase),
                            tint = Color.White,
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(all = 10.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Tài chính",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.height(20.dp)
                        )
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp, 8.dp, 8.dp, 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painterResource(R.drawable.ic_briefcase),
                            tint = Color.White,
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(all = 10.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Ngày công",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.height(20.dp)
                        )
                    }

                }
            }
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
        floatingActionButtonPosition = FabPosition.Center
    )
    {
        LazyColumn(state = state) {

            item {
                Dashboard(
                    navController = navController
                )
            }
            item() {
                Text(
                    stringResource(R.string.home_task_reports),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)
                )
                Divider(
                    color = DividerColor
                )
            }
            items(5){
                    item ->  ItemReport()
            }
        }
    }

}