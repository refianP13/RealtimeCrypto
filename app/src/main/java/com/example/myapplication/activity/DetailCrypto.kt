package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.squareup.picasso.Picasso

class DetailCrypto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_crypto)
        val kembali = findViewById<ImageView>(R.id.left_icon)
        kembali.setOnClickListener(){
            startActivity(Intent(this,Tabel::class.java))
        }
        var inNama = intent.getStringExtra("nama")
        var inData = intent.getStringExtra("data")
        var inBeli = intent.getStringExtra("beli")
        var inPict = intent.getStringExtra("pict")
        var inSell = intent.getStringExtra("jual")
        var volume = intent.getStringExtra("vol")
        var nama = findViewById<TextView>(R.id.nama)
        var data = findViewById<TextView>(R.id.data)
        var beliHarga = findViewById<TextView>(R.id.beli)
        var jualHarga = findViewById<TextView>(R.id.jual)
        var pict = findViewById<ImageView>(R.id.detailGambar)
        Picasso.get()
            .load(inPict)
            .into(pict);
        nama.text = inNama
        data.text = inData
        beliHarga.text = inBeli
        jualHarga.text = inSell

        var beli = findViewById<Button>(R.id.beliDetail)
        beli.setOnClickListener(){
            startActivity(Intent(this,MainActivity::class.java))
        }
        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener(){
            startActivity(Intent(this, Menu::class.java))
        }
    }
}