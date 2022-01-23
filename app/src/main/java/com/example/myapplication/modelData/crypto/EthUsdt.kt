package com.example.myapplication.modelData.crypto

data class EthUsdt(
    val high: String,
    val low: String,
    val vol_eth: String,
    val vol_usdt: String,
    val last: String,
    val buy: String,
    val sell: String,
    val server_time: Int,
    val name: String
)