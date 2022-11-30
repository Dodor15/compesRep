package com.example.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.BackgroundCol200
import com.example.compose.ui.theme.ComposeTheme

class SettingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  BackgroundCol200
                ) {
                    Settings("Android")
                }
            }
        }
    }
}

@Composable
fun Settings(name: String) {
    Column() {
    UperText(Name = "Настройки")
    Spacer(modifier = Modifier.height(30.dp))
        CreateSetting(Name = "Профиль пользователя", MainActivity())
        CreateSetting(Name = "Дата и время", activ = MainActivity())
        CreateSetting(Name = "Настройки звука", activ = MainActivity())
        CreateSetting(Name = "Проверить обновления", activ =MainActivity())
    }
    Box(modifier = Modifier, contentAlignment = Alignment.BottomCenter){
        MainMenu(menu = 4)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    ComposeTheme {
        Settings("Android")
    }
}

@Composable
fun CreateSetting(Name:String, activ: ComponentActivity){
    Box() {
        Box(Modifier.padding(24.dp), contentAlignment = Alignment.TopStart) {

                val context = LocalContext.current
                TextButton(onClick = { context.startActivity(Intent(context, activ::class.java)) }) {
                    Text(
                        text = Name,
                        fontSize = 22.sp,
                        color = Color.White,
                    )
                }

        }
        Box(
            Modifier
                .padding(24.dp)
                .fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(R.drawable.vector),
                    contentDescription = "sd",
                    Modifier.size(15.dp)
                )
            }
        }
    }
}