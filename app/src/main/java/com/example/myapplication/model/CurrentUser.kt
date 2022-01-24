package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Currentuser_table")
data class CurrentUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nama: String,
    val email: String,
    val notel: String,
    val pass: String
)//: Parcelable
