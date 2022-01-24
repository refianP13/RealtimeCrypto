package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.CurrentUser
import com.example.roomapp.data.UserDao
import com.example.roomapp.model.User

@Database(entities = [CurrentUser::class], version = 1, exportSchema = false)
abstract class CurrentUserDatabase : RoomDatabase() {

    abstract fun CurrentuserDao(): CurrentUserDao

    companion object {
        @Volatile
        private var INSTANCE: CurrentUserDatabase? = null

        fun getDatabase(context: Context): CurrentUserDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CurrentUserDatabase::class.java,
                    "Currentuser_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}