package com.example.healthlog.networking

data class HomeStateHolder
    (
            val isLoading:Boolean = false,
            val data: List<Article>? = null,
            val error: String = ""
    )