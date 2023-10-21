package com.example.newsflashv2.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class SourceResponse(
    @Json(name = "status")
    val status: String,
    @Json(name = "sources")
    val sources: List<Source>
) {
    @Parcelize
    data class Source(
        @Json(name = "id")
        val id: String?,
        @Json(name = "name")
        val name: String?,
        @Json(name = "description")
        val description: String?,
        @Json(name = "url")
        val url: String?,
        @Json(name = "category")
        val category: String?,
        @Json(name = "language")
        val language: String?,
        @Json(name = "country")
        val country: String?,
    ) : Parcelable
}