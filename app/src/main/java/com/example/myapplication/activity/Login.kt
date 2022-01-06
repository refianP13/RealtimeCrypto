package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login = findViewById<Button>(R.id.login)
        val guest = findViewById<Button>(R.id.guest)
        login.setOnClickListener(){
            startActivity(Intent(this@Login,Menu::class.java))
        }
        guest.setOnClickListener(){
            startActivity(Intent(this@Login,Menu::class.java))
        }
    }

}