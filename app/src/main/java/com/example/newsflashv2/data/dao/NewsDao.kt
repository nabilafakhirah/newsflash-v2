package com.example.newsflashv2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.newsflashv2.data.model.NewsEntity
import com.example.newsflashv2.utils.NEWS_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM $NEWS_TABLE ORDER BY title ASC")
    fun getBookmarkedNews(): Flow<NewsEntity>

    @Query("SELECT * FROM $NEWS_TABLE WHERE url = :url")
    suspend fun getNews(url: String): NewsEntity

    @Insert(onConflict = IGNORE)
    suspend fun addNews(news: NewsEntity)

    @Delete
    suspend fun deleteNews(news: NewsEntity)
}