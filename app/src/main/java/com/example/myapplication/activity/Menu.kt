package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewmodel.CurrentUserViewModel
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    private lateinit var mCurrentUserViewModel: CurrentUserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val tabel = findViewById<ImageButton>(R.id.tabel)
        val profilk = findViewById<ImageButton>(R.id.profilPas)
        val setting = findViewById<ImageButton>(R.id.settingImage)
        val logout = findViewById<Button>(R.id.logout)

        mCurrentUserViewModel = ViewModelProvider(this).get(CurrentUserViewModel::class.java)
        mCurrentUserViewModel.readAllData.observe(this, Observer {
            if(!it.isEmpty())
                textView6.text = "Welcome ${it[0].nama}"
        })
        tabel.setOnClickListener(){
            startActivity(Intent(this@Menu,Tabel::class.java))
        }
        profilk.setOnClickListener(){
            startActivity(Intent(this@Menu,ProfilPage::class.java))
        }
        setting.setOnClickListener(){
            startActivity(Intent(this@Menu,Pengaturan::class.java))
        }
        logout.setOnClickListener(){
            mCurrentUserViewModel = ViewModelProvider(this).get(CurrentUserViewModel::class.java)
            mCurrentUserViewModel.deleteAllUsers()
            startActivity(Intent(this@Menu,GetStarted::class.java))
        }

    }
}