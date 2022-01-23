package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.roomapp.data.UserDao
import com.example.roomapp.model.User
import com.example.roomapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_registrasi.*

class Registrasi : AppCompatActivity() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        val regon = findViewById<Button>(R.id.Regist)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        regon.setOnClickListener(){
            insertDataToDatabase()
            startActivity(Intent(this@Registrasi, Login::class.java))
        }


    }
    private fun insertDataToDatabase() {
        var userDao: UserDao
        val nama = NamaReg.text.toString()
        val email = EmailReg.text.toString()
        val notel = NoHPReg.text.toString()
        val pass = password.text.toString()

        if(inputCheck(nama, email, notel, pass)){
            // Create User Object
            val user = User(
                0,
                nama,
                email,
                notel,
                pass
            )
            // Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(applicationContext, "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
        }else{
            Toast.makeText(applicationContext, "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(nama: String, email: String, notel: String, pass: String): Boolean{
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(email) && TextUtils.isEmpty(notel) && TextUtils.isEmpty(pass))
    }
}