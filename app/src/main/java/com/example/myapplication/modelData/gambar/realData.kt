package com.example.myapplication.modelData.gambar

data class realData(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    var support: Support,
    val total_pages: Int
)