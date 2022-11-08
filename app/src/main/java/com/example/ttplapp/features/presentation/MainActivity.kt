package com.example.ttplapp

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ttplapp.ui.theme.Orange
import com.example.ttplapp.ui.theme.TTPLAppTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ttplapp.features.presentation.Screen
import com.example.ttplapp.features.presentation.home.components.HomeScreen
import com.example.ttplapp.ui.theme.BackgroundNeutral
import com.example.ttplapp.ui.theme.Content3
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                color = MaterialTheme.colors.background
            ) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.route
                ) {
                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen(navController = navController)
                    }
                }
            }
        }
    }
//    @Composable
//    fun Screen(){
//        val state by remember { mutableStateOf(FormState()) }
//
//        Column {
//            Form(
//                state = state,
//                fields = listOf(
//                    Field(name = "username", validators = listOf(Required())),
//                    Field(name = "email", validators = listOf(Required(), Email()))
//                )
//            )
//            Button(onClick = { if (state.validate()) toast("Our form works!") }) {
//                Text("Submit")
//            }
//        }
//    }
//
//    // the toast extension function
//    private fun Context.toast(message: String){
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview() {
    TTPLAppTheme {
        val scaffoldState = rememberScaffoldState()
        val navController = rememberNavController()
        val scope = rememberCoroutineScope()
        var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
            mutableStateOf(TextFieldValue("example", TextRange(0, 7)))
        }
        Scaffold(
            drawerContent = {
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                Divider()
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
                                     Icon(Icons.Default.Close,
                                        contentDescription = null
                                         )
                                 }
                             },
                             leadingIcon = {
                                 Icon(Icons.Default.Search,
                                     contentDescription = null
                                 )
                             },
                             shape = RoundedCornerShape(10.dp),
                             colors = TextFieldDefaults.textFieldColors(
                                 backgroundColor = BackgroundNeutral,
                                focusedIndicatorColor =  Color.Transparent, //hide the indicator
                                unfocusedIndicatorColor = BackgroundNeutral),
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
            bottomBar = {BottomBar(navController = navController)},
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

        }

    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val bottomMenuItemsList = prepareBottomMenu()

    val contextForToast = LocalContext.current.applicationContext
    val navController = rememberNavController()
    var selectedItem by remember {
        mutableStateOf("Home")
    }
    Box(modifier = Modifier.fillMaxWidth()){
        BottomAppBar(
            backgroundColor = Color.White,
            cutoutShape = CircleShape,
            elevation =  20.dp,
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))

        ) {
            bottomMenuItemsList.forEachIndexed { index, menuItem ->
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
                    selected = (selectedItem == menuItem.label),
                    onClick = {
                        selectedItem = menuItem.label
                        Toast.makeText(
                            contextForToast,
                            menuItem.label, Toast.LENGTH_SHORT
                        ).show()
                    },
                    icon = {
                        Icon(
                            imageVector = menuItem.icon,
                            contentDescription = menuItem.label,
                        )
                    },
                    label = {
                        Text(text = menuItem.label)
                    },
                    enabled = true
                )
            }
        }
    }
}




private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()

    // add menu items
    bottomMenuItemsList.add(BottomMenuItem(label = "Home", icon = Icons.Filled.Home))
    bottomMenuItemsList.add(BottomMenuItem(label = "Profile", icon = Icons.Filled.Person))
    bottomMenuItemsList.add(BottomMenuItem(label = "Cart", icon = Icons.Filled.ShoppingCart))
    bottomMenuItemsList.add(BottomMenuItem(label = "Settings", icon = Icons.Filled.Settings))

    return bottomMenuItemsList
}

data class BottomMenuItem(val label: String, val icon: ImageVector)




@Preview
@Composable
fun BItemReportPreview() {
    TTPLAppTheme {
        ItemReport(Color(0xFFFCF6E8))
    }
}

@Composable
fun ItemReport(
    color: Color
) {
    Box(
        modifier = Modifier
            .background(Color.White)
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
                    Icon(Icons.Filled.Home,
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color(0xFFF0AD00))
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(all = 10.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Linh Trần",
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
                    .background(Color(0xFFF0AD00),
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
                    )) {
                        append("Task: ")
                    }
                    append("#1338 - Admin: Bảng điều khiển ")
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
                        )) {
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
                    )) {
                        append("Project: ")
                    }
                    append("Luật Legalzone")
                },
                fontSize = 12.sp,

                )

        }
    }
}

@Preview
@Composable
fun ItemFormPreview() {
    TTPLAppTheme {
        ItemForm(Color(0xFFFCF6E8))
    }
}

@Composable
fun ItemForm(
    color: Color
) {
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val mCities = listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {

        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {Text("Label")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            mCities.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText = label
                    mExpanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
}
