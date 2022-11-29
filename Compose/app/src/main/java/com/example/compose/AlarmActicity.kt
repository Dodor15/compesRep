package com.example.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.*

class AlarmActicity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  BackgroundCol200
                ) {
                    Alarm("Android")
                }
            }
        }
    }
}

@Composable
fun Alarm(name: String) {
    val context = LocalContext.current
    Column() {
        UperText(Name = "Будильник")
        Spacer(modifier = Modifier.height(40.dp))
        AlarmSwitch(Time = "9:00")
        AlarmSwitch(Time = "7:30")
    }
    
   
    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.height(100.dp)){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {


            Button(
                onClick = {
                    context.startActivity(Intent(context, GeneralActivity::class.java))
                },
                Modifier
                    .size(300.dp, 60.dp)
                    .background(BtnCol), colors = ButtonDefaults.buttonColors(BtnCol)
            ) {
                Text(text = "Добавить будильник", fontSize = 15.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(60.dp))

            MainMenu(2)

        }
    }
}

@Composable
fun AlarmSwitch(Time:String) {
    Box() {
        Box(Modifier.padding(24.dp), contentAlignment = Alignment.TopStart) {
            Text(text = Time, fontSize = 24.sp, color = Color.White)
        }
        Box(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
            SwitchCooler(switchPadding = 8.dp, buttonWidth = 124.dp, buttonHeight = 64.dp, value =false )
        }
    }
}










@Composable
fun SwitchCooler(
    switchPadding: Dp,
    buttonWidth: Dp,
    buttonHeight: Dp,
    value: Boolean
    ){
    val switchSize by remember{
        mutableStateOf(buttonHeight-switchPadding*2)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }

    var switchClicker by remember {
        mutableStateOf(value)
    }
    var padding by remember {
        mutableStateOf(0.dp)
    }

    padding = if(switchClicker) buttonWidth-switchSize-switchPadding*2 else 0.dp

    val animateSize by animateDpAsState(
        targetValue =
        if(switchClicker) padding else 0.dp,
        tween(durationMillis = 200,
        delayMillis = 0,
        easing = LinearOutSlowInEasing
        )
    )

    Box(modifier = Modifier
        .width(buttonWidth)
        .height(buttonHeight)
        .clip(CircleShape)
        .background(if (switchClicker) onCol else OffCol)
        .clickable(
            interactionSource = interactionSource,
            indication = null
        ) {
            switchClicker = !switchClicker
        })

    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(switchPadding))
        {
            Box(modifier = Modifier
                .fillMaxHeight()
                .width(animateSize)
                .background(Color.Transparent))

            Box(modifier = Modifier
                .size(switchSize)
                .clip(CircleShape)
                .background(Color.White)
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ComposeTheme {
        Alarm("Android")
    }
}