package com.example.myapplication.modelData.crypto

data class BullUsdt(
    val high: String,
    val low: String,
    val vol_bull: String,
    val vol_usdt: String,
    val last: String,
    val buy: String,
    val sell: String,
    val server_time: Int,
    val name: String
)