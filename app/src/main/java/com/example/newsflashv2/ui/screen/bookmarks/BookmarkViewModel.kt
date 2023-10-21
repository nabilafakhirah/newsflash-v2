package com.example.newsflashv2.ui.screen.bookmarks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsflashv2.data.model.NewsEntity
import com.example.newsflashv2.domain.DeleteNewsFromRoomUseCase
import com.example.newsflashv2.domain.GetNewsFromRoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    getNewsFromRoomUseCase: GetNewsFromRoomUseCase,
    private val deleteNewsFromRoomUseCase: DeleteNewsFromRoomUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    init {
        val newsList = getNewsFromRoomUseCase.execute()
        _state.value = BookmarkState(
            bookmarkList = newsList
        )
    }

    fun deleteFromBookmark(newsEntity: NewsEntity) = viewModelScope.launch {
        deleteNewsFromRoomUseCase.execute(newsEntity)
    }
}