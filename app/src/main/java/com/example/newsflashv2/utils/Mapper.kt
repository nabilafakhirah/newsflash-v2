package com.example.newsflashv2.utils

import com.example.newsflashv2.data.model.NewsEntity
import com.example.newsflashv2.data.model.NewsResponse

fun NewsResponse.Article.newsEntityMapper(): NewsEntity {
    return NewsEntity(
        url = this.url,
        author = this.author.orEmpty(),
        content = this.content.orEmpty(),
        description = this.description,
        publishedAt = this.publishedAt,
        title = this.title,
        urlToImage = this.urlToImage.orEmpty()
    )
}