package com.example.myapplication.modelData.crypto

data class PxgUsdt(
    val high: String,
    val low: String,
    val vol_pxg: String,
    val vol_usdt: String,
    val last: String,
    val buy: String,
    val sell: String,
    val server_time: Int,
    val name: String
)