package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.CurrentUserDatabase
import com.example.myapplication.model.CurrentUser
import com.example.myapplication.repository.CurrentUserRepository
import com.example.roomapp.data.UserDatabase
import com.example.roomapp.model.User
import com.example.roomapp.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrentUserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<CurrentUser>>
    private val repository: CurrentUserRepository

    init {
        val userDao = CurrentUserDatabase.getDatabase(
            application
        ).CurrentuserDao()
        repository = CurrentUserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: CurrentUser){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user: CurrentUser){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: CurrentUser){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }

}