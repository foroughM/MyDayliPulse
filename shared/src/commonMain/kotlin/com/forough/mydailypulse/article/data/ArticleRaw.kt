package com.forough.mydailypulse.article.data

import com.forough.mydailypulse.article.application.Article
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    val description: String?,
    @SerialName("publishedAt")
    val date: String,
    val title: String,
    @SerialName("urlToImage")
    val image: String?
)

fun ArticleRaw.toArticle() = Article(
    title = this.title,
    desc = this.description ?: "click to find out more",
    date = this.date,
    imageUrl = this.image
        ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
)