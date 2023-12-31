package com.example.newsflashv2.ui.screen.bookmarks

import com.example.newsflashv2.data.model.NewsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class BookmarkState (
    val bookmarkList: Flow<List<NewsEntity>> = emptyFlow()
)