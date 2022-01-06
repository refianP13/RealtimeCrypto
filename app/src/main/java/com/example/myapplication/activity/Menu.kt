package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val tabel = findViewById<Button>(R.id.tabel)
        tabel.setOnClickListener(){
            startActivity(Intent(this@Menu,Tabel::class.java))
        }

    }
}