package com.forough.mydailypulse.source.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourceService(
    private val httpClient: HttpClient
) {

    private val apiKey: String = "d545787f6c2142f7a98b48ef1f21ffa6"

    suspend fun getSources(): List<SourceRaw> {
        val response: SourceResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey").body()
        return response.sources
    }
}