package com.example.ttplapp.features.presentation.home.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ttplapp.R
import com.example.ttplapp.features.presentation.home.components.NoRippleTheme.bounceClick
import com.example.ttplapp.ui.theme.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class User(
    val image: String,
    val fullName: String,
    val email: String
)
private val listItems = mutableListOf(
    User(
        image = "https://st.depositphotos.com/1018174/2732/i/950/depositphotos_27324093-stock-photo-beautiful-portrait-of-young-man.jpg",
        fullName = "HUMAN",
        email = "ingo@human.com"
    ),
    User(
        image = "https://static7.depositphotos.com/1004998/792/i/950/depositphotos_7921089-stock-photo-green-trees.jpg",
        fullName = "TRETS",
        email = "ingo@triest.com"
    ),
    User(
        image = "https://st2.depositphotos.com/1454412/6603/i/950/depositphotos_66033865-stock-photo-big-red-tree.jpg",
        fullName = "REDDYO",
        email = "ingo@reddyo.com"
    ),
    User(
        image = "https://st.depositphotos.com/1018174/2732/i/950/depositphotos_27324093-stock-photo-beautiful-portrait-of-young-man.jpg",
        fullName = "HUMAN",
        email = "ingo@human.com"
    ),
    User(
        image = "https://static7.depositphotos.com/1004998/792/i/950/depositphotos_7921089-stock-photo-green-trees.jpg",
        fullName = "TRETS",
        email = "ingo@triest.com"
    ),
    User(
        image = "https://st2.depositphotos.com/1454412/6603/i/950/depositphotos_66033865-stock-photo-big-red-tree.jpg",
        fullName = "REDDYO",
        email = "ingo@reddyo.com"
    ),
    User(
        image = "https://st.depositphotos.com/1018174/2732/i/950/depositphotos_27324093-stock-photo-beautiful-portrait-of-young-man.jpg",
        fullName = "HUMAN",
        email = "ingo@human.com"
    ),
    User(
        image = "https://static7.depositphotos.com/1004998/792/i/950/depositphotos_7921089-stock-photo-green-trees.jpg",
        fullName = "TRETS",
        email = "ingo@triest.com"
    ),
    User(
        image = "https://st2.depositphotos.com/1454412/6603/i/950/depositphotos_66033865-stock-photo-big-red-tree.jpg",
        fullName = "REDDYO",
        email = "ingo@reddyo.com"
    ),
    User(
        image = "https://st.depositphotos.com/1018174/2732/i/950/depositphotos_27324093-stock-photo-beautiful-portrait-of-young-man.jpg",
        fullName = "HUMAN",
        email = "ingo@human.com"
    ),
    User(
        image = "https://static7.depositphotos.com/1004998/792/i/950/depositphotos_7921089-stock-photo-green-trees.jpg",
        fullName = "TRETS",
        email = "ingo@triest.com"
    ),
    User(
        image = "https://st2.depositphotos.com/1454412/6603/i/950/depositphotos_66033865-stock-photo-big-red-tree.jpg",
        fullName = "REDDYO",
        email = "ingo@reddyo.com"
    )
)
@Composable
fun UsersScreen(
    navController: NavController
){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            item {
                Text(
                    stringResource(R.string.home_all_user),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 8.dp)
                )
                Divider(
                    color = DividerColor
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ){
                    Button(
                        onClick = {

                        },

                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Orange.copy(alpha = 0.1f),
                            contentColorFor(backgroundColor = Orange.copy(alpha = 0.1f)),
                            disabledBackgroundColor = Orange,

                        ),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            disabledElevation = 0.dp
                        ),

                        ) {
                        Icon(
                            painterResource(R.drawable.ic_mail),
                            tint = Orange,
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .fillMaxWidth()
                                .fillMaxHeight()

                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            stringResource(R.string.home_send_invite),
                            fontSize = 12.sp,
                            color = Orange,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.height(20.dp)
                        )

                    }
                    Button(onClick = {

                    },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Orange
                        )
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_plus),
                            tint = Color.White,
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .fillMaxWidth()
                                .fillMaxHeight()
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            stringResource(id = R.string.home_add_user),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500,
                            color = Color.White,
                            modifier = Modifier.height(20.dp)
                        )
                    }
                }
            }
            
            items(listItems){
                    user ->
                UserItem(user = user)

            }
        }

    }
}


@Composable
fun UserItem(
    user: User
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("${user.image}")
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
            Text("${user.fullName}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.height(20.dp)
            )
            Text("${user.email}",
                fontSize = 12.sp,
                color= Content3,
                modifier = Modifier.height(18.dp)
            )
        }
    }
}

@Preview
@Composable
fun Button(){
    Surface(
        color = Color.White
    ) {
        Button(
            onClick = {

            },
            interactionSource = remember { MutableInteractionSource(
            ) },

            colors = ButtonDefaults.buttonColors(
                backgroundColor = Orange.copy(alpha = 0.1f),
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            ),

            ) {
            Icon(
                painterResource(R.drawable.ic_mail),
                tint = Orange,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()

            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                stringResource(R.string.home_send_invite),
                fontSize = 12.sp,
                color = Orange,
                fontWeight = FontWeight.W500,
                modifier = Modifier.height(20.dp)
            )

        }

    }
}
class NoRippleInteractionSource : MutableInteractionSource {

    override val interactions: Flow<Interaction> = emptyFlow()

    override suspend fun emit(interaction: Interaction) {}

    override fun tryEmit(interaction: Interaction) = true
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        draggedAlpha = 0.0f,
        focusedAlpha = 0.0f,
        hoveredAlpha = 0.0f,
        pressedAlpha = 0.0f
    )

    fun Modifier.bounceClick() = composed {
        var buttonState by remember { mutableStateOf(ButtonState.Idle) }
        val scale by animateFloatAsState(if (buttonState == ButtonState.Pressed) 0.70f else 1f)

        this
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { }
            )
            .pointerInput(buttonState) {
                awaitPointerEventScope {
                    buttonState = if (buttonState == ButtonState.Pressed) {
                        waitForUpOrCancellation()
                        ButtonState.Idle
                    } else {
                        awaitFirstDown(false)
                        ButtonState.Pressed
                    }
                }
            }
    }

}
enum class ButtonState { Pressed, Idle }

fun Modifier.shakeClickEffect() = composed {
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }
    val tx by animateFloatAsState(
        targetValue = if (buttonState == ButtonState.Pressed) 0f else -50f,
        animationSpec = repeatable(
            iterations = 2,
            animation = tween(durationMillis = 50, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    this
        .graphicsLayer {
            translationX = tx
        }
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = { }
        )
        .pointerInput(buttonState) {
            awaitPointerEventScope {
                buttonState = if (buttonState == ButtonState.Pressed) {
                    waitForUpOrCancellation()
                    ButtonState.Idle
                } else {
                    awaitFirstDown(false)
                    ButtonState.Pressed
                }
            }
        }
}