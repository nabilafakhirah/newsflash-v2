package com.example.newsflashv2.ui.screen.newslist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsflashv2.data.model.NewsResponse
import com.example.newsflashv2.domain.AddNewsToRoomUseCase
import com.example.newsflashv2.domain.GetNewsBySourcesUseCase
import com.example.newsflashv2.domain.SearchNewsUseCase
import com.example.newsflashv2.utils.newsEntityMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsBySourcesUseCase: GetNewsBySourcesUseCase,
    private val searchNewsUseCase: SearchNewsUseCase,
    private val addNewsToRoomUseCase: AddNewsToRoomUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _state

    fun getNewsListBySource(sourceId: String) {
        val newsResponse = getNewsBySourcesUseCase.execute(sourceId)
        _state.value = NewsListState(
            isLoading = false,
            sourceList = newsResponse,
            error = null
        )
    }

    fun getNewsListByQuery(sourceId: String, query: String) {
        val newsResponse = searchNewsUseCase.execute(query = query, sourceId = sourceId)
        _state.value = NewsListState(
            isLoading = false,
            sourceList = newsResponse,
            error = null
        )
    }

    fun addToBookmark(news: NewsResponse.Article) = viewModelScope.launch {
        val newsEntity = news.newsEntityMapper()
        addNewsToRoomUseCase.execute(newsEntity)
    }
}