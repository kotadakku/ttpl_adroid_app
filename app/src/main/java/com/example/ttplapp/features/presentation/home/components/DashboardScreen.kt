package com.example.ttplapp.features.presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ttplapp.R
import com.example.ttplapp.ui.theme.DividerColor

@Composable
fun DashboardScreen(
    navController: NavController
){
    val state = rememberLazyListState()
    LazyColumn(state = state) {

        item {
            Dashboard(
                navController = navController
            )
        }
        item {
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