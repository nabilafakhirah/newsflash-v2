package com.example.newsflashv2.data.repository

import com.example.newsflashv2.data.dao.NewsDao
import com.example.newsflashv2.data.model.NewsEntity
import kotlinx.coroutines.flow.Flow

class NewsStorageRepositoryImpl(
    private val newsDao: NewsDao
) : NewsStorageRepository {
    override fun getNewsFromRoom(): Flow<List<NewsEntity>> {
        return newsDao.getBookmarkedNews()
    }

    override suspend fun getNews(url: String): NewsEntity {
        return newsDao.getNews(url)
    }

    override suspend fun addNewsToRoom(newsEntity: NewsEntity) {
        newsDao.addNews(newsEntity)
    }

    override suspend fun deleteNewsFromRoom(newsEntity: NewsEntity) {
        newsDao.deleteNews(newsEntity)
    }

}