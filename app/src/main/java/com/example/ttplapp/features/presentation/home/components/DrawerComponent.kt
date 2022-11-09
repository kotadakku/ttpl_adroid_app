package com.example.ttplapp.features.presentation.home.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ttplapp.R
import com.example.ttplapp.ui.theme.Content3
import com.example.ttplapp.ui.theme.DividerColor

@Composable
fun DrawerComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 60.dp, 16.dp, 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://st.depositphotos.com/1018174/2732/i/950/depositphotos_27324093-stock-photo-beautiful-portrait-of-young-man.jpg")
                    .crossfade(true)
                    .build(),
                //placeholder = painterResource(R.drawable.placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape).size(40.dp)
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
        DrawerItem(
            icon = R.drawable.ic_user_plus,
            title = R.string.home_care,
            onClick = {

            }
        )
        DrawerItem(
            icon = R.drawable.ic_wallet,
            title = R.string.home_financial,
            onClick = {

            }
        )
        DrawerItem(
            icon = R.drawable.ic_calendar_off,
            title = R.string.home_leave,
            onClick = {

            }
        )
        DrawerItem(
            icon = R.drawable.ic_chart_pie,
            title = R.string.home_survey,
            onClick = {

            }
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 8.dp, 8.dp, 8.dp)
            .fillMaxHeight()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 20.dp)
                .clickable {

                }
        ){
            Icon(
                painterResource(R.drawable.ic_ogout),
                tint = Color.Red,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = 10.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Đăng xuất",
                color = Color.Red,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.height(20.dp)
            )
        }

    }


}

@Composable
fun DrawerItem(
    @StringRes title: Int,
    @DrawableRes icon: Int,
    onClick: ()-> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 8.dp, 8.dp, 8.dp)
            .clickable {
                onClick
            },
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painterResource(icon),
                tint = Color.Black,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = 10.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                stringResource(id = title),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.height(20.dp)
            )
        }

    }
}