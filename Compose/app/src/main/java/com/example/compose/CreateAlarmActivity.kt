package com.example.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.BackgroundCol200
import com.example.compose.ui.theme.BtnCol
import com.example.compose.ui.theme.ComposeTheme

class CreateAlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  BackgroundCol200
                ) {
                    CreateAlarm("Android")
                }
            }
        }
    }
}

@Composable
fun CreateAlarm(name: String) {
    val context = LocalContext.current
    Column() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            UperText(Name = "Изменить задачу")
            DoubleText()

        }
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Повторять каждый", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            CreateCheckBox(text = "Понедельник бездельник")
            Spacer(modifier = Modifier.height(16.dp))
            CreateCheckBox(text = "Вторник повторник")
            Spacer(modifier = Modifier.height(16.dp))
            CreateCheckBox(text = "Среда тамада")
            Spacer(modifier = Modifier.height(16.dp))
            CreateCheckBox(text = "Четверг все заботы я отверг")
            Spacer(modifier = Modifier.height(16.dp))
            CreateCheckBox(text = "Пятница развратница))")
            Spacer(modifier = Modifier.height(16.dp))
            CreateCheckBox(text = "Субора не работа")
            Spacer(modifier = Modifier.height(16.dp))
            CreateCheckBox(text = "Воскресенье день веселья")

        }
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 0.dp, 0.dp, 40.dp), contentAlignment = Alignment.BottomCenter) {
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

@Composable
fun CreateCheckBox(text: String)
{
    val checkedState = remember { mutableStateOf(false) }
    Row{
        Box(
            Modifier
                .background(Color.White)
                .size(18.dp)){
            Checkbox(
                checked = checkedState.value,
                modifier = Modifier.size(16.dp),
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.Yellow
                )
            )
        }
        Text(text, fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(8.dp,0.dp,0.dp,0.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    ComposeTheme {
        CreateAlarm("Android")
    }
}