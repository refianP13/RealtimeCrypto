package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewmodel.CurrentUserViewModel
import com.example.roomapp.data.UserDao
import com.example.roomapp.model.User
import com.example.roomapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_profil_page.*

class ProfilPage : AppCompatActivity() {
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var mCurrentUServiewModel : CurrentUserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_page)

        val tes = findViewById<TextView>(R.id.textView5)
        mCurrentUServiewModel =ViewModelProvider(this).get(CurrentUserViewModel::class.java)
        mCurrentUServiewModel.readAllData.observe(this, Observer {
            //tes.text = it[0].nama.toString()
            if(!it.isEmpty()) {
                nama.text = it[0].nama
                email.text = it[0].email
                notel.text = it[0].notel
            }
        })

        val back = findViewById<ImageView>(R.id.left_icon)
        back.setOnClickListener(){
            startActivity(Intent(this@ProfilPage, Menu::class.java))
        }
        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener(){
            startActivity(Intent(this@ProfilPage, Menu::class.java))
        }
    }
}