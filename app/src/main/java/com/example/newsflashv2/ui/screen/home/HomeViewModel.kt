package com.example.newsflashv2.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.newsflashv2.domain.GetNewsCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsCategoriesUseCase: GetNewsCategoriesUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getCategories()
    }

    private fun getCategories() {
        val categories = getNewsCategoriesUseCase.execute()
        _state.value = HomeState(
            categoryList = categories
        )
    }
}