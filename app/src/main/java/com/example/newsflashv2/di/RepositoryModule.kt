package com.example.newsflashv2.di

import com.example.newsflashv2.data.api.NewsApi
import com.example.newsflashv2.data.dao.NewsDao
import com.example.newsflashv2.data.repository.NewsRepository
import com.example.newsflashv2.data.repository.NewsRepositoryImpl
import com.example.newsflashv2.data.repository.NewsStorageRepository
import com.example.newsflashv2.data.repository.NewsStorageRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideStorageRepository(newsDao: NewsDao): NewsStorageRepository {
        return NewsStorageRepositoryImpl(newsDao)
    }
}