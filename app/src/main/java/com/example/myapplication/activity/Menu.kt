package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.myapplication.R

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val tabel = findViewById<ImageButton>(R.id.tabel)
        val profilk = findViewById<ImageButton>(R.id.profilPas)
        val setting = findViewById<ImageButton>(R.id.settingImage)
        tabel.setOnClickListener(){
            startActivity(Intent(this@Menu,Tabel::class.java))
        }
        profilk.setOnClickListener(){
            startActivity(Intent(this@Menu,ProfilPage::class.java))
        }
        setting.setOnClickListener(){
            startActivity(Intent(this@Menu,Pengaturan::class.java))
        }

    }
}