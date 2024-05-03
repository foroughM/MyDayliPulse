package com.forough.mydailypulse.article.application

import com.forough.mydailypulse.article.data.ArticleRepository
import com.forough.mydailypulse.article.data.toArticle

class ArticleUseCase(
    private val articleRepository: ArticleRepository
) {

    suspend fun getArticles(isForce: Boolean): List<Article> {
        val articles = articleRepository.getArticles(isForce)
        return articles.map { articleRaw -> articleRaw.toArticle() }
    }
}
