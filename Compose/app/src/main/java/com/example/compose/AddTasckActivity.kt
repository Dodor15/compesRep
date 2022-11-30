package com.example.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.BackgroundCol200
import com.example.compose.ui.theme.BtnCol
import com.example.compose.ui.theme.ComposeTheme

class AddTasckActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  BackgroundCol200
                ) {
                    AddTasck("Android")
                }
            }
        }
    }
}

@Composable
fun AddTasck(name: String) {
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        UperText(Name = "Добавить задачу")
        SimpleFilledTextFieldSample(Name = "Заголовок задачи")
        DoubleText()
        BigEditText()
    }
    Box(modifier = Modifier.fillMaxWidth().padding(0.dp,0.dp,0.dp,40.dp), contentAlignment = Alignment.BottomCenter) {
        Column() {


            Button(
                onClick = {
                    context.startActivity(Intent(context, GeneralActivity::class.java))
                },
                Modifier
                    .size(300.dp, 60.dp)
                    .background(BtnCol), colors = ButtonDefaults.buttonColors(BtnCol)
            ) {
                Text(text = "Добавить задачу", fontSize = 15.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    ComposeTheme {
        AddTasck("Android")
    }
}