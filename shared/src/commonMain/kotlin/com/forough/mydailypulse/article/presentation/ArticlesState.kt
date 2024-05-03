package com.forough.mydailypulse.article.presentation

import com.forough.mydailypulse.article.application.Article

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
