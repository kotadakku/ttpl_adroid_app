package com.example.ttplapp.features.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.ttplapp.R
import com.example.ttplapp.ui.theme.BackgroundNeutral
import com.example.ttplapp.ui.theme.Blue
import com.example.ttplapp.ui.theme.DividerColor
import com.example.ttplapp.ui.theme.Orange
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalUnitApi::class)
@Composable
fun ProjectsScreen(
    navController: NavController
) {
    Surface(
        color = MaterialTheme.colors.onSecondary
    ) {
        // on below line we are creating variable for pager state.
        val pagerState = rememberPagerState(pageCount = 3)

        // on below line we are creating a column for our widgets.
        Column(
            // for column we are specifying modifier on below line.
            modifier = Modifier.background(Color.White)
        ) {
            Text(
                stringResource(R.string.home_all_client),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 8.dp)
            )
            Divider(
                color = DividerColor
            )
            Tabs(pagerState = pagerState)
            TabsContent(pagerState = pagerState)
        }

    }
}
// on below line we are
// creating a function for tabs
@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 16.dp).height(37.dp),
    ){
        Button(onClick = {
            scope.launch {
                pagerState.animateScrollToPage(0)
            }
        },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (pagerState.currentPage == 0) Orange.copy(alpha = 0.1F) else BackgroundNeutral
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            )
            ){
            Text(
                stringResource(id = R.string.projects),
                color = if (pagerState.currentPage == 0) Orange else Color.Black
                )
        }
        Button(onClick = {
            scope.launch {
                pagerState.animateScrollToPage(1)
            }
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (pagerState.currentPage == 1) Orange.copy(alpha = 0.1F) else BackgroundNeutral
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp
        )){
            Text(stringResource(id = R.string.kpi),
                color = if (pagerState.currentPage == 1) Orange else Color.Black
                )
        }
    }
}
c
// on below line we are creating a tab content method
// in which we will be displaying the individual page of our tab .
@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            0 -> TabContentScreen(data = "Welcome to Home Screen", pagerState = pagerState)
            1 -> TabContentScreen(data = "Welcome to Shopping Screen", pagerState = pagerState)
        }
    }
}

// on below line we are creating a Tab Content
// Screen for displaying a simple text message.
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContentScreen(data: String, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    // on below line we are creating a column
    Column(
        // in this column we are specifying modifier
        // and aligning it center of the screen on below lines.
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // in this column we are specifying the text
        Text(
            // on below line we are specifying the text message
            text = data,

            // on below line we are specifying the text style.
            style = MaterialTheme.typography.h5,

            // on below line we are specifying the text color
            color = Orange,

            // on below line we are specifying the font weight
            fontWeight = FontWeight.Bold,

            //on below line we are specifying the text alignment.
            textAlign = TextAlign.Center
        )
        DemoTable()
    }
}


@Composable
fun <T> Table(
    columnCount: Int,
    cellWidth: (index: Int) -> Dp,
    data: List<T>,
    modifier: Modifier = Modifier,
    headerCellContent: @Composable (index: Int) -> Unit,
    cellContent: @Composable (index: Int, item: T) -> Unit,
) {
    Surface(
        modifier = modifier
    ) {
        LazyRow(
            modifier = Modifier.padding(16.dp)
        ) {
            items((0 until columnCount).toList()) { columnIndex ->
                Column {
                    (0..data.size).forEach { index ->
                        Surface(
                            color = if(index%2==1) Blue.copy(alpha = 0.05f) else Color.Transparent,
                            contentColor = Color.Transparent,
                            modifier = Modifier.width(cellWidth(columnIndex))
                        ) {
                            if (index == 0) {
                                headerCellContent(columnIndex)
                            } else {
                                cellContent(columnIndex, data[index - 1])
                            }
                        }
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun DemoTable() {
    val people = listOf(
        Person("Alex", 21, false, "alex@demo-email.com"),
        Person("Adam", 35, true, "adam@demo-email.com"),
        Person("Iris", 26, false, "iris@demo-email.com"),
        Person("Maria", 32, false, "maria@demo-email.com"),
        Person("Alex", 21, false, "alex@demo-email.com"),
        Person("Adam", 35, true, "adam@demo-email.com"),
        Person("Iris", 26, false, "iris@demo-email.com"),
        Person("Maria", 32, false, "maria@demo-email.com"),
        Person("Alex", 21, false, "alex@demo-email.com"),
        Person("Adam", 35, true, "adam@demo-email.com"),
        Person("Iris", 26, false, "iris@demo-email.com"),
        Person("Maria", 32, false, "maria@demo-email.com"),
        Person("Alex", 21, false, "alex@demo-email.com"),
        Person("Adam", 35, true, "adam@demo-email.com"),
        Person("Iris", 26, false, "iris@demo-email.com"),
        Person("Maria", 32, false, "maria@demo-email.com")
    )

    val cellWidth: (Int) -> Dp = { index ->
        when (index) {
            2 -> 250.dp
            3 -> 350.dp
            else -> 150.dp
        }
    }
    val headerCellTitle: @Composable (Int) -> Unit = { index ->
        val value = when (index) {
            0 -> "Name"
            1 -> "Age"
            2 -> "Has driving license"
            3 -> "Email"
            else -> ""
        }

        Text(
            text = value,
            color = Orange,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Black,
        )
    }
    val cellText: @Composable (Int, Person) -> Unit = { index, item ->
        val value = when (index) {
            0 -> item.name
            1 -> item.age.toString()
            2 -> if (item.hasDrivingLicence) "YES" else "NO"
            3 -> item.email
            else -> ""
        }

        Text(
            text = value,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }

    Table(
        columnCount = 4,
        cellWidth = cellWidth,
        data = people,
        modifier = Modifier.verticalScroll(rememberScrollState()),
        headerCellContent = headerCellTitle,
        cellContent = cellText
    )
}

data class Person(val name: String,
val age: Int,
val hasDrivingLicence: Boolean,
val email: String )