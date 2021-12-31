package com.example.myapplication.api



import com.example.myapplication.modelData.crypto.aaData
import com.example.myapplication.modelData.gambar.realData
import com.example.myapplication.modelData.gambar.srcGambarItem
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("https://indodax.com/api/pairs")
    fun getDatag(): Call<ArrayList<srcGambarItem>>
    @GET("api/users?page=2")
    fun getDatas(): Call<realData>
    @GET("https://indodax.com/api/summaries")
    fun getDatah(): Call<aaData>
}