package com.example.myapplication.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_crypto.*

class DetailCrypto : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
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
        data.text = volume
        beliHarga.text = inBeli
        jualHarga.text = inSell

        textView2.text = "${inNama} adalah koin yang memiliki potensi tinggi untuk menjadi koin hebat," +
                "mungkin saja dalam beberapa tahun kdepan dapat seharga 2 kali lipat dari harga saat ini yakni " +
                "${(inBeli?.toInt())?.times(2)}. Untuk saat ini koin tersebut memiliki traded min currency sebesar ${inData} di" +
                " Exchange Indodax"

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