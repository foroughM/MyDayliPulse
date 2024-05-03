package com.forough.mydailypulse.article.data

import com.forough.mydailypulse.article.data.ArticleRaw
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    val articles: List<ArticleRaw>,
    val status: String,
    val totalResults: Int
)