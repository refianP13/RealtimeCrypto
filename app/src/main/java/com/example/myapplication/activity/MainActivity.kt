package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.R
import com.example.myapplication.adapter.bitcoinAdapter

import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.modelData.crypto.AaveIdr
import com.example.myapplication.modelData.crypto.Tickers
import com.example.myapplication.modelData.crypto.aaData

import com.example.myapplication.modelData.gambar.Data
import com.example.myapplication.modelData.gambar.passingBuy

import com.example.myapplication.modelData.gambar.realData
import com.example.myapplication.modelData.gambar.srcGambarItem
import com.google.gson.Gson
import kotlin.reflect.full.memberProperties
import com.squareup.picasso.Picasso
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

import kotlin.reflect.jvm.reflect


class MainActivity : AppCompatActivity() {
    //buat recyler view nih ingat woy
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this@MainActivity,Login::class.java))

    }

}