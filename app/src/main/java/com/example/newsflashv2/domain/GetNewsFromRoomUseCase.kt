package com.example.newsflashv2.domain

import com.example.newsflashv2.data.model.NewsEntity
import com.example.newsflashv2.data.repository.NewsStorageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsFromRoomUseCase @Inject constructor(
    private val newsStorageRepository: NewsStorageRepository
) {
    fun execute(): Flow<List<NewsEntity>> {
        return newsStorageRepository.getNewsFromRoom()
    }
}