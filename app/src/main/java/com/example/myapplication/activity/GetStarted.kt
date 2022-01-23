package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class GetStarted : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
        val launch = findViewById<Button>(R.id.getStarted)

        launch.setOnClickListener(){
            startActivity(Intent(this@GetStarted,Login::class.java))
        }
    }
}