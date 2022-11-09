package com.example.ttplapp.features.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ttplapp.R
import com.example.ttplapp.ui.theme.Content3
import com.example.ttplapp.ui.theme.DividerColor
import com.example.ttplapp.ui.theme.TTPLAppTheme

data class Client(
    val image: String,
    val companyName: String,
    val email: String
    )
private val listItems = mutableListOf(
    Client(
        image = "https://st.depositphotos.com/1018174/2732/i/950/depositphotos_27324093-stock-photo-beautiful-portrait-of-young-man.jpg",
        companyName = "HUMAN",
        email = "ingo@human.com"
    ),
    Client(
        image = "https://static7.depositphotos.com/1004998/792/i/950/depositphotos_7921089-stock-photo-green-trees.jpg",
        companyName = "TRETS",
        email = "ingo@triest.com"
    ),
    Client(
        image = "https://st2.depositphotos.com/1454412/6603/i/950/depositphotos_66033865-stock-photo-big-red-tree.jpg",
        companyName = "REDDYO",
        email = "ingo@reddyo.com"
    ),
    Client(
        image = "https://st.depositphotos.com/1018174/2732/i/950/depositphotos_27324093-stock-photo-beautiful-portrait-of-young-man.jpg",
        companyName = "HUMAN",
        email = "ingo@human.com"
    ),
    Client(
        image = "https://static7.depositphotos.com/1004998/792/i/950/depositphotos_7921089-stock-photo-green-trees.jpg",
        companyName = "TRETS",
        email = "ingo@triest.com"
    ),
    Client(
        image = "https://st2.depositphotos.com/1454412/6603/i/950/depositphotos_66033865-stock-photo-big-red-tree.jpg",
        companyName = "REDDYO",
        email = "ingo@reddyo.com"
    ),
    Client(
        image = "https://st.depositphotos.com/1018174/2732/i/950/depositphotos_27324093-stock-photo-beautiful-portrait-of-young-man.jpg",
        companyName = "HUMAN",
        email = "ingo@human.com"
    ),
    Client(
        image = "https://static7.depositphotos.com/1004998/792/i/950/depositphotos_7921089-stock-photo-green-trees.jpg",
        companyName = "TRETS",
        email = "ingo@triest.com"
    ),
    Client(
        image = "https://st2.depositphotos.com/1454412/6603/i/950/depositphotos_66033865-stock-photo-big-red-tree.jpg",
        companyName = "REDDYO",
        email = "ingo@reddyo.com"
    ),
    Client(
        image = "https://st.depositphotos.com/1018174/2732/i/950/depositphotos_27324093-stock-photo-beautiful-portrait-of-young-man.jpg",
        companyName = "HUMAN",
        email = "ingo@human.com"
    ),
    Client(
        image = "https://static7.depositphotos.com/1004998/792/i/950/depositphotos_7921089-stock-photo-green-trees.jpg",
        companyName = "TRETS",
        email = "ingo@triest.com"
    ),
    Client(
        image = "https://st2.depositphotos.com/1454412/6603/i/950/depositphotos_66033865-stock-photo-big-red-tree.jpg",
        companyName = "REDDYO",
        email = "ingo@reddyo.com"
    )
)
@Composable
fun ClientsScreen(
    navController: NavController
){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth().fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            item {
                Text(
                    stringResource(R.string.home_all_client),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 8.dp)
                )
                Divider(
                    color = DividerColor
                )
            }
            items(listItems){
                client ->
                ClientItem(client = client)

            }
        }

    }
}


@Composable
fun ClientItem(
    client: Client
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("${client.image}")
                .crossfade(true)
                .build(),
            //placeholder = painterResource(R.drawable.placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(){
            Text("${client.companyName}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.height(20.dp)
            )
            Text("${client.email}",
                fontSize = 12.sp,
                color= Content3,
                modifier = Modifier.height(18.dp)
            )
        }
    }
}