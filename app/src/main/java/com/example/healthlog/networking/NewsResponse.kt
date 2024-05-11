package com.example.healthlog.networking

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName


data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    var status:String?,
    @SerializedName("totalResults")
    val totalResult:Int?
)


data class Article(
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String?
)


data class Source(
    @SerializedName("id")
    val id: Any?,
    @SerializedName("name")
    val name: String
)