package com.example.ttplapp.features.presentation.home.components

import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.stopScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun ItemReport(
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ){
        Column() {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
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
                        modifier = Modifier.clip(CircleShape).size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Linh Tr???n",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text("3:20, 12/6/2021",
                    fontSize = 12.sp,
                    color= Color.Gray,
                )

            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .background(
                        Color(0xFFF0AD00),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(vertical = 2.5.dp, horizontal = 12.dp)
            ){
                Text("Updated",
                    fontSize = 12.sp,
                    color= Color.White,

                    )
            }
            Text("Updated",
                fontSize = 12.sp,
                color= Color.White,

                )
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color= Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    ) {
                        append("Task: ")
                    }
                    append("#1338 - Admin: B???ng ??i???u khi???n ")
                },
                fontSize = 12.sp,

                )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(Color.Black)

                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Project: Moved Down",
                    fontSize = 12.sp,
                    color= Color.Black,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(Color.Black)

                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    buildAnnotatedString {
                        append("Status: ")
                        withStyle(style = SpanStyle(
                            color= Color.Blue,
                            fontWeight = FontWeight.Bold
                        )
                        ) {
                            append("Code Review")
                        }

                    },
                    fontSize = 12.sp,

                    )
            }
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color= Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    ) {
                        append("Project: ")
                    }
                    append("Lu???t Legalzone")
                },
                fontSize = 12.sp,

                )

        }
    }
}