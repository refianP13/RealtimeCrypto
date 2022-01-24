package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.model.CurrentUser
import com.example.roomapp.model.User

@Dao
interface CurrentUserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: CurrentUser)

    @Update
    fun updateUser(user: CurrentUser)

    @Delete
    fun deleteUser(user: CurrentUser)

    @Query("DELETE FROM Currentuser_table")
    fun deleteAllUsers()

    @Query("SELECT * FROM Currentuser_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<CurrentUser>>
}

