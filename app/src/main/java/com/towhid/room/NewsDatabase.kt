package com.towhid.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.towhid.newsnew.retrofit.response.Article

@Database(entities = [Article::class,ArticleRemoteKey::class],version = 1)
abstract class NewsDatabase : RoomDatabase() {
    companion object{
        fun getInstance(context: Context):NewsDatabase{
            return Room.databaseBuilder(context,NewsDatabase::class.java,"name").build()
        }
    }
    abstract fun getNewsDao():NewsDao
}