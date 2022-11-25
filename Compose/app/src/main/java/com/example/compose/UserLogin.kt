package com.example.compose

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.BackgroundCol200
import com.example.compose.ui.theme.ComposeTheme

class UserLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  BackgroundCol200
                ) {
                    User()
                }
            }
        }
    }
}



@Composable
fun User() {
    UperText( "Войти")
    Column(
    ) {

    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()){

       EText("Имя пользователя")
    }


}
@Composable
fun EText(Name: String){
    TextField(value = Name, onValueChange = {})
}


@Composable
fun UperText(Name:String){
    Box(Modifier.padding(8.dp), contentAlignment = Alignment.TopStart) {
        Text(text = Name, fontSize = 30.sp, color = Color.White,)
    }
    Box(Modifier.padding(8.dp), contentAlignment = Alignment.TopEnd){
        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(R.drawable.back_button),
                contentDescription = "sd",
                Modifier.size(50.dp, 50.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeTheme {
        User()
    }
}