package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.CurrentUserDao
import com.example.myapplication.model.CurrentUser
import com.example.myapplication.viewmodel.CurrentUserViewModel
import com.example.roomapp.data.UserDao
import com.example.roomapp.model.User
import com.example.roomapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.password
import kotlinx.android.synthetic.main.activity_registrasi.*


class Login : AppCompatActivity() {
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var mCurrentUserViewModel: CurrentUserViewModel
    private lateinit var saka : List<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var benar = 0
        val login = findViewById<Button>(R.id.login)
        val guest = findViewById<Button>(R.id.guest)
        val register = findViewById<Button>(R.id.register)
        mCurrentUserViewModel = ViewModelProvider(this).get(CurrentUserViewModel::class.java)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        login.setOnClickListener(){
            mUserViewModel.readAllData.observe(this, Observer {
                saka = it
                for(i in saka.indices){
                    if((email.text.toString()==saka[i].email)&&(password.text.toString()==saka[i].pass)) {
                        insertDataToDatabase(saka[i].nama,saka[i].email,saka[i].notel,saka[i].pass)
                        startActivity(Intent(this@Login,Menu::class.java))
                        benar = 1
                    }
                }
                if(benar==0)
                    Toast.makeText(applicationContext, "Email atau Sandi Salah :(", Toast.LENGTH_SHORT).show()
            })
        }
        guest.setOnClickListener(){
            startActivity(Intent(this@Login,Menu::class.java))
        }
        register.setOnClickListener(){
            startActivity(Intent(this@Login,Registrasi::class.java))
        }
    }
    private fun insertDataToDatabase(a : String,b : String ,c : String ,d : String) {
        val nama = a
        val email = b
        val notel = c
        val pass = d

        if(inputCheck(nama, email, notel, pass)){
            // Create User Object
            val user = CurrentUser(
                0,
                nama,
                email,
                notel,
                pass
            )
            // Add Data to Database
            mCurrentUserViewModel.addUser(user)
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