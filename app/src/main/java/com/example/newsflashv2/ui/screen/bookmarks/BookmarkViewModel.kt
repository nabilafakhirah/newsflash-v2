package com.example.newsflashv2.ui.screen.bookmarks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsflashv2.data.model.NewsEntity
import com.example.newsflashv2.data.repository.NewsStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val storageRepository: NewsStorageRepository
) : ViewModel() {
    val news = storageRepository.getNewsFromRoom()

    fun deleteFromBookmark(newsEntity: NewsEntity) = viewModelScope.launch {
        storageRepository.deleteNewsFromRoom(newsEntity)
    }
}