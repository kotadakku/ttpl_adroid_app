package com.example.ttplapp.features.presentation.home.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ttplapp.ui.theme.TTPLAppTheme
import com.example.ttplapp.R
import com.example.ttplapp.ui.theme.DividerColor

data class Item(
    val backgroundColor: Color,
    val color: Color,
    @StringRes  val  title: Int,
    @DrawableRes val icon: Int,
    val amount: Int,
    val onClick: () -> Unit
)

private val listItems = mutableListOf(
    Item(
        color = Color(0xFFF0AD00),
        backgroundColor = Color(0xFFFCF6E8),
        title = R.string.project,
        icon = R.drawable.ic_briefcase,
        amount = 12,
        onClick = {

        }
    ),
    Item(
        color = Color(0xFF41DC8F),
        backgroundColor = Color(0xFFECFAF3),
        title = R.string.all_task,
        icon = R.drawable.ic_subtask,
        amount = 12,
        onClick = {

        }
    ),Item(
        color = Color(0xFF19A3DE),
        backgroundColor = Color(0xFFD6EDFA),
        title = R.string.project,
        icon = R.drawable.ic_subtask,
        amount = 12,
        onClick = {

        }
    )
)

@Composable
fun Dashboard(
    navController: NavController
){
    Column {
        Text(
            stringResource(R.string.home_dashboard),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)
        )
        Divider(
            color = DividerColor
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(listItems){
                item ->  DashboardItem(item = item)
            }
        }
    }
}

@Composable
fun DashboardItem(
    item: Item,
) {
    TTPLAppTheme {
        Box(
            modifier = Modifier
                .width(223.dp)
                .height(80.dp)
                .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
                .clickable(onClick = item.onClick)
        ){
            Row(
                modifier = Modifier
                    .background(item.backgroundColor)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)

                ){
                    Icon(
                        painterResource(item.icon),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(44.dp)
                            .background(item.color)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(all = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(){
                    Text(
                        stringResource(item.title),
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp),

                        )
                    Text("${item.amount}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}