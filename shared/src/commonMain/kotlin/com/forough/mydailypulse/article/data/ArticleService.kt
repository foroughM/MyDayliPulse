package com.forough.mydailypulse.article.data

import com.forough.mydailypulse.article.data.ArticleRaw
import com.forough.mydailypulse.article.data.ArticleResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {

    private val country: String = "US"
    private val category: String = "business"
    private val apiKey: String = "d545787f6c2142f7a98b48ef1f21ffa6"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val apiResponse : ArticleResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return apiResponse.articles
    }
}