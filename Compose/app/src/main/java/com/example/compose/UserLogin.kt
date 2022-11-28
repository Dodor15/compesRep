package com.example.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.BackgroundCol200
import com.example.compose.ui.theme.BtnCol
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
    val context = LocalContext.current
    UperText( "Войти")
    Column(
    ) {

    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            ){
        Column() {
            SimpleFilledTextFieldSample("Имя пользователя")
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextField()
            Spacer(modifier = Modifier.height(45.dp))
            Button(onClick = {context.startActivity(Intent(context, GeneralActivity::class.java))
            },
                Modifier
                    .size(300.dp, 60.dp)
                    .background(BtnCol), colors = ButtonDefaults.buttonColors(BtnCol)){
                Text(text = "Войти", fontSize = 15.sp, color = Color.White)
            }
        }

    }

}




@Composable
fun SimpleFilledTextFieldSample(Name: String) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(Name) }
    )
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun UperText(Name:String){
    Box(Modifier.padding(24.dp), contentAlignment = Alignment.TopStart) {
        Text(text = Name, fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
    Box(Modifier.padding(16.dp), contentAlignment = Alignment.TopEnd){
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