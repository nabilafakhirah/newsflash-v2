package com.example.newsflashv2.data.repository

import androidx.paging.PagingData
import com.example.newsflashv2.data.model.NewsResponse
import com.example.newsflashv2.data.model.SourceResponse
import com.example.newsflashv2.utils.DataResult
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNewsBySources(sources: String): Flow<PagingData<NewsResponse.Article>>

    fun getSourcesByCategory(category: String): Flow<DataResult<SourceResponse>>

    fun searchNews(query : String, sourceId: String) : Flow<PagingData<NewsResponse.Article>>

    fun getNewsCategories() : List<String>
}