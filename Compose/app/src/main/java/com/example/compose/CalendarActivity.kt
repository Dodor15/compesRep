package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.theme.BackgroundCol200
import com.example.compose.ui.theme.ComposeTheme

class CalendarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  BackgroundCol200
                ) {
                    CalendarAct("Android")
                    
                    Box(modifier = Modifier, contentAlignment = Alignment.BottomCenter){
                        MainMenu(menu = 3)
                    }
                }
            }
        }
    }
}

@Composable
fun CalendarAct(name: String) {
    UperText(Name = "Календарь")

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    ComposeTheme {
        CalendarAct("Android")
    }
}