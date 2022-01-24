package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewmodel.CurrentUserViewModel

class GetStarted : AppCompatActivity() {
    private lateinit var mCurrentUserViewModel: CurrentUserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
        val launch = findViewById<Button>(R.id.getStarted)
        mCurrentUserViewModel = ViewModelProvider(this).get(CurrentUserViewModel::class.java)
        mCurrentUserViewModel.readAllData.observe(this, Observer {
            if(!it.isEmpty())
                startActivity(Intent(this@GetStarted,Menu::class.java))
        })
        launch.setOnClickListener(){
            startActivity(Intent(this@GetStarted,Login::class.java))
        }
    }
}