package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R

class Pengaturan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengaturan)
        val back = findViewById<ImageView>(R.id.left_icon)
        back.setOnClickListener(){
            startActivity(Intent(this@Pengaturan, Menu::class.java))
        }
        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener(){
            startActivity(Intent(this, Menu::class.java))
        }
    }
}