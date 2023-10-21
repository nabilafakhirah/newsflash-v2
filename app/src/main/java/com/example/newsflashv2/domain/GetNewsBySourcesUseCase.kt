package com.example.newsflashv2.domain

import androidx.paging.PagingData
import com.example.newsflashv2.data.model.NewsResponse
import com.example.newsflashv2.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsBySourcesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    fun execute(sources: String): Flow<PagingData<NewsResponse.Article>> {
        return newsRepository.getNewsBySources(sources)
    }
}