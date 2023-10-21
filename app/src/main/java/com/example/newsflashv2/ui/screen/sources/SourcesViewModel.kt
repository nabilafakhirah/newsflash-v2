package com.example.newsflashv2.ui.screen.sources

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsflashv2.data.model.SourceResponse
import com.example.newsflashv2.domain.GetSourcesByCategoryUseCase
import com.example.newsflashv2.utils.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(
    private val getSourcesByCategoryUseCase: GetSourcesByCategoryUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(SourcesState())
    val state: State<SourcesState> = _state
    private var initialSources: List<SourceResponse.Source> = emptyList()

    fun getSourcesFromCategory(category: String) {
        val sourceResponse = getSourcesByCategoryUseCase.execute(category)
        sourceResponse.onEach { result ->
            when (result) {
                is DataResult.Success -> {
                    initialSources = result.data?.sources ?: emptyList()
                    _state.value = SourcesState(
                        isLoading = false,
                        sourceList = result.data?.sources ?: emptyList()
                    )
                }
                is DataResult.Error -> _state.value = SourcesState(
                    isLoading = false,
                    error = result.message
                )
                is DataResult.Loading -> _state.value = SourcesState(
                    isLoading = true,
                    error = result.message
                )
            }
        }.launchIn(viewModelScope)
    }

    fun filterSources(keyword: String) {
        val filteredSourceList = initialSources.filter {
            it.name?.contains(keyword) ?: false
        }

        _state.value = SourcesState(
            isLoading = false,
            sourceList = filteredSourceList
        )
    }
}