package com.example.newsflashv2.domain

import com.example.newsflashv2.data.repository.NewsRepository
import javax.inject.Inject

class GetNewsCategoriesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    fun execute(): List<String> {
        return newsRepository.getNewsCategories()
    }
}