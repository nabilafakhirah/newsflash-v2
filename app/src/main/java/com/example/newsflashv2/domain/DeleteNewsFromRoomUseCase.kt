package com.example.newsflashv2.domain

import com.example.newsflashv2.data.model.NewsEntity
import com.example.newsflashv2.data.repository.NewsStorageRepository
import javax.inject.Inject

class DeleteNewsFromRoomUseCase @Inject constructor(
    private val newsStorageRepository: NewsStorageRepository
) {
    suspend fun execute(newsEntity: NewsEntity) {
        return newsStorageRepository.deleteNewsFromRoom(newsEntity)
    }
}