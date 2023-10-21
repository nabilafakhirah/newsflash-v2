package com.example.newsflashv2.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsflashv2.data.dao.NewsDao
import com.example.newsflashv2.data.model.NewsEntity

@Database(
    entities = [NewsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
    abstract val newsDao: NewsDao
}