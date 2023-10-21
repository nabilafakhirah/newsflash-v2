package com.example.newsflashv2.ui.screen.newslist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsflashv2.data.model.NewsEntity
import com.example.newsflashv2.data.model.NewsResponse
import com.example.newsflashv2.data.repository.NewsRepository
import com.example.newsflashv2.data.repository.NewsStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val repository: NewsRepository,
    private val storageRepository: NewsStorageRepository,
) : ViewModel() {

    private val _state = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _state

    fun getNewsListBySource(sourceId: String) {
        val newsResponse = repository.getNewsBySources(sourceId)
        _state.value = NewsListState(
            isLoading = false,
            sourceList = newsResponse,
            error = null
        )
    }

    fun getNewsListByQuery(sourceId: String, query: String) {
        val newsResponse = repository.searchNews(query = query, sourceId = sourceId)
        _state.value = NewsListState(
            isLoading = false,
            sourceList = newsResponse,
            error = null
        )
    }

    fun addToBookmark(news: NewsResponse.Article) = viewModelScope.launch {
        val newsEntity = NewsEntity(
            url = news.url,
            author = news.author.orEmpty(),
            content = news.content.orEmpty(),
            description = news.description,
            publishedAt = news.publishedAt,
            title = news.title,
            urlToImage = news.urlToImage.orEmpty()
        )
        storageRepository.addNewsToRoom(newsEntity)
    }
}