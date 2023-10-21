package com.example.newsflashv2.di

import com.example.newsflashv2.data.repository.NewsRepository
import com.example.newsflashv2.data.repository.NewsStorageRepository
import com.example.newsflashv2.domain.AddNewsToRoomUseCase
import com.example.newsflashv2.domain.DeleteNewsFromRoomUseCase
import com.example.newsflashv2.domain.GetNewsBySourcesUseCase
import com.example.newsflashv2.domain.GetNewsCategoriesUseCase
import com.example.newsflashv2.domain.GetNewsFromRoomUseCase
import com.example.newsflashv2.domain.GetSourcesByCategoryUseCase
import com.example.newsflashv2.domain.SearchNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetNewsBySourcesUseCase(newsRepository: NewsRepository):
    GetNewsBySourcesUseCase {
        return GetNewsBySourcesUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideSearchNewsUseCase(newsRepository: NewsRepository):
    SearchNewsUseCase {
        return SearchNewsUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideGetSourcesByCategoryUseCase(newsRepository: NewsRepository):
            GetSourcesByCategoryUseCase {
        return GetSourcesByCategoryUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideGetNewsCategoriesUseCase(newsRepository: NewsRepository):
            GetNewsCategoriesUseCase {
        return GetNewsCategoriesUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideGetNewsFromRoomUseCase(newsStorageRepository: NewsStorageRepository):
            GetNewsFromRoomUseCase {
        return GetNewsFromRoomUseCase(newsStorageRepository)
    }

    @Provides
    @Singleton
    fun provideAddNewsToRoomUseCase(newsStorageRepository: NewsStorageRepository):
            AddNewsToRoomUseCase {
        return AddNewsToRoomUseCase(newsStorageRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteNewsFromRoomUseCase(newsStorageRepository: NewsStorageRepository):
            DeleteNewsFromRoomUseCase {
        return DeleteNewsFromRoomUseCase(newsStorageRepository)
    }
}