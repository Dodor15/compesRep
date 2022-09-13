package com.example.laba10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
   private lateinit var btn: Button
   private lateinit var pass:EditText
   private lateinit var textUP: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences = getSharedPreferences("str", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        val password=preferences.getString("str","why?").toString()

        pass=findViewById(R.id.editTextNumberPassword)
        btn= findViewById(R.id.button)
        textUP = findViewById(R.id.textView)

        if(preferences.contains("str")==true){
            textUP.text = "Введи пароль"
        }
        else {
            textUP.text="Создай проль"
        }
        editor.clear()
        btn.setOnClickListener{

            if(preferences.contains("str")==true){
                if(pass.text.toString()==password){
                   val intent= Intent(this, InformaionActivity::class.java)
                    startActivity(intent)

                }
            }
            else{
                editor.putString("str",pass.text.toString())
                editor.apply()
                Toast.makeText(this, "Пароль создан",Toast.LENGTH_SHORT).show()
            }
        }



    }
}