package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R

class DetailCrypto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_crypto)

        var kode = findViewById<TextView>(R.id.kode)
        kode.setText(intent.getStringExtra("koin"))
        var beli = findViewById<Button>(R.id.beliDetail)
        beli.setOnClickListener(){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}