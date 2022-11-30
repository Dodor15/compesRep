package com.example.compose

import android.os.Bundle
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
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

                }
            }
        }
    }
}

@Composable
fun CalendarAct(name: String) {
Column() {
    UperText(Name = "Календарь")
    Box(modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp)) {
        CreateSecondCalendar()
    }
}



    Box(modifier = Modifier, contentAlignment = Alignment.BottomCenter){
        MainMenu(menu = 3)
    }
}


@Composable
fun CreateSecondCalendar()
{
    AndroidView({ CalendarView(it) },
        modifier = Modifier.wrapContentWidth(),
        update = { views ->
            views.setOnDateChangeListener { calendarView, i, i2, i3 ->
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    ComposeTheme {
        CalendarAct("Android")
    }
}