package com.example.newsflashv2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsflashv2.utils.NEWS_TABLE

@Entity(tableName = NEWS_TABLE)
data class NewsEntity(
    @PrimaryKey(autoGenerate = false)
    val url: String,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val urlToImage: String,
)