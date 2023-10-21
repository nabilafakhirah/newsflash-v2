package com.example.newsflashv2.ui.screen.sources

import com.example.newsflashv2.data.model.SourceResponse

data class SourcesState(
    var isLoading: Boolean = false,
    val sourceList: List<SourceResponse.Source> = emptyList(),
    val error: String? = ""
)