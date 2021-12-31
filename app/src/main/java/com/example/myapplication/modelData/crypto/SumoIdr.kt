package com.example.myapplication.modelData.crypto

data class SumoIdr(
    val high: String,
    val low: String,
    val vol_sumo: String,
    val vol_idr: String,
    val last: String,
    val buy: String,
    val sell: String,
    val server_time: Int,
    val name: String
)