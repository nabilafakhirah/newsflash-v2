package com.example.newsflashv2.data.repository

import com.example.newsflashv2.data.model.NewsEntity
import kotlinx.coroutines.flow.Flow


interface NewsStorageRepository {
    fun getNewsFromRoom(): Flow<List<NewsEntity>>
    suspend fun getNews(url: String): NewsEntity
    suspend fun addNewsToRoom(newsEntity: NewsEntity)
    suspend fun deleteNewsFromRoom(newsEntity: NewsEntity)
}