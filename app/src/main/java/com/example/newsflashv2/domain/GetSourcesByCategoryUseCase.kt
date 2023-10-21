package com.example.newsflashv2.domain

import com.example.newsflashv2.data.model.SourceResponse
import com.example.newsflashv2.data.repository.NewsRepository
import com.example.newsflashv2.utils.DataResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSourcesByCategoryUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    fun execute(category: String): Flow<DataResult<SourceResponse>> {
        return newsRepository.getSourcesByCategory(category)
    }
}