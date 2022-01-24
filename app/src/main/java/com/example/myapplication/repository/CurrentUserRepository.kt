package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.CurrentUserDao
import com.example.myapplication.model.CurrentUser
import com.example.roomapp.data.UserDao
import com.example.roomapp.model.User

class CurrentUserRepository(private val userDao: CurrentUserDao) {

    val readAllData: LiveData<List<CurrentUser>> = userDao.readAllData()

    suspend fun addUser(user: CurrentUser){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: CurrentUser){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: CurrentUser){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }

}