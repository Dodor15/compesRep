package com.example.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.*

class GeneralActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  BackgroundCol200
                ) {
                    General("Android")
                }
            }
        }
    }
}

@Composable
fun General(name: String) {
    val context = LocalContext.current
    UperText("Список дел")
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column() {
            Taskcard("Вечерний поход в кино", "Идём в кино с колегами!", "10.02.2021", "19:40")
            Spacer(modifier = Modifier.height(16.dp))
            Taskcard(
                "Забрать заказ с озон",
                "Пункт выдачи на ул. Ленина, 103",
                "10.02.2021",
                "19:40"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Taskcard(Uper = "Запись в автосервис", Lower = "Сдать автомобиль в автосервис на ул. Бисер, д. 14, замена масла", Data = "10.02.2021", Time = "19:40")
        }
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
                Text(text = "Войти", fontSize = 15.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(60.dp))
            Box(modifier = Modifier.background(BtnCol) ){
                MainMenu(1)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposeTheme {
        General("Android")
    }
}

@Composable
fun Taskcard(Uper:String, Lower:String, Data:String, Time:String){
    Card(shape = Shapes.large,
        modifier = Modifier
            .size(330.dp, 90.dp)
            .clickable { },
        elevation = 10.dp,
        backgroundColor = TaskCol){
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(16.dp, 12.dp, 0.dp, 0.dp)) {
            Text(Uper, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Text(modifier = Modifier.width(248.dp), text =  Lower, maxLines = 2, fontSize = 11.sp, color = DopCol)
        }
        Column(horizontalAlignment =  Alignment.End, modifier = Modifier.padding(0.dp, 17.dp, 8.dp, 0.dp)) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(Data, fontSize = 11.sp, color = DopCol)
                Text(Time, fontSize = 11.sp, color = DopCol)
            }
        }
    }
}
@Composable
fun MainMenu(menu:Int){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(0.dp, 20.dp, 20.dp, 0.dp))
        .size(360.dp, 100.dp)) {
        Row(horizontalArrangement = Arrangement.Center) {
            IconButton(onClick = { /*TODO*/ },) {
                if (menu == 1) {
                    Image(
                        painter = painterResource(R.drawable.green_list),
                        contentDescription = "sdff",
                        modifier = Modifier.size(70.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.red_list),
                        contentDescription = "sdsad",
                        modifier = Modifier.size(70.dp)
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ },) {
                if (menu == 2) {
                    Image(
                        painter = painterResource(R.drawable.alarm_green),
                        contentDescription = "sdff",
                        modifier = Modifier.size(70.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.alarm_red),
                        contentDescription = "sdsad",
                        modifier = Modifier.size(70.dp)
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ },) {
                if (menu == 3) {
                    Image(

                        painter = painterResource(R.drawable.calendar_green),
                        contentDescription = "sdff",
                        modifier = Modifier.size(70.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.calendar_red),
                        contentDescription = "sdsad",
                        modifier = Modifier.size(70.dp)
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ },) {
                if (menu == 4) {
                    Image(
                        painter = painterResource(R.drawable.setting_green),
                        contentDescription = "sdff",
                        modifier = Modifier.size(70.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.setting_red),
                        contentDescription = "sdsad",
                        modifier = Modifier.size(70.dp)
                    )
                }
            }
        }

    }
}
