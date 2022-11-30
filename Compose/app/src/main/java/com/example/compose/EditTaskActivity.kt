package com.example.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.BackgroundCol200
import com.example.compose.ui.theme.BtnCol
import com.example.compose.ui.theme.ComposeTheme

class EditTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  BackgroundCol200
                ) {
                    EditTask("Android")
                }
            }
        }
    }
}

@Composable
fun EditTask(name: String) {
    val context = LocalContext.current
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            UperText(Name = "Изменить задачу")
            SimpleFilledTextFieldSample(Name = "Заголовок задачи")
            DoubleText()
            BigEditText()
        }
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 0.dp, 0.dp, 40.dp), contentAlignment = Alignment.BottomCenter){
        Column() {


            Button(
                onClick = {
                    context.startActivity(Intent(context, GeneralActivity::class.java))
                },
                Modifier
                    .size(300.dp, 60.dp)
                    .background(BtnCol), colors = ButtonDefaults.buttonColors(Color.Red)
            ) {
                Text(text = "Удалить задачу", fontSize = 15.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    context.startActivity(Intent(context, GeneralActivity::class.java))
                },
                Modifier
                    .size(300.dp, 60.dp)
                    .background(BtnCol), colors = ButtonDefaults.buttonColors(BtnCol)
            ) {
                Text(text = "Записать задачу", fontSize = 15.sp, color = Color.White)
            }
        }
    }
    
}

@Composable
fun DoubleText(){
    var text by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("")}

    Box() {
        Box(Modifier.padding(24.dp), contentAlignment = Alignment.TopStart) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("16:30") },
                modifier = Modifier
                    .size(160.dp, 60.dp)
                    .background(Color.Transparent)
                    .clip(shape = RoundedCornerShape(15.dp)),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.mini_alarm), contentDescription = "clock", modifier = Modifier.size(16.dp))
                }
            )

        }
        Box(
            Modifier
                .padding(24.dp)
                .fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
            TextField(
                value = text2,
                onValueChange = { text2 = it },
                label = { Text("14.01.2021") },
                modifier = Modifier
                    .size(160.dp,60.dp)
                    .background(Color.Transparent)
                    .clip(shape = RoundedCornerShape(15.dp)),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.mini_calendar),
                        contentDescription = "clock",
                        modifier = Modifier.size(16.dp)
                    )
                }
            )
        }
    }
}

@Composable
fun BigEditText(){
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Описание задачи") },
        modifier = Modifier
            .size(350.dp,150.dp)
            .background(Color.Transparent)
            .clip(shape = RoundedCornerShape(15.dp)),
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    ComposeTheme {
        EditTask("Android")
    }
}