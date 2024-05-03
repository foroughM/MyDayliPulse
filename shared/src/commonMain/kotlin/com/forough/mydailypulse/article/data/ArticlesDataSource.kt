package com.forough.mydailypulse.article.data

import com.forough.mydailypulse.db.MyDailyPulseDatabase


class ArticlesDataSource(
    private val database: MyDailyPulseDatabase
) {

    fun getAllArticles(): List<ArticleRaw> {
        return database.myDailyPulseDatabaseQueries.selectAllArticles(::mapToArticleRaw)
            .executeAsList()
    }

    fun insertAllArticles(articles: List<ArticleRaw>) {
        database.myDailyPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() = database.myDailyPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.myDailyPulseDatabaseQueries.insertArticle(
            articleRaw.title,
            articleRaw.description,
            articleRaw.date,
            articleRaw.image
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw = ArticleRaw(
        title = title,
        description = desc,
        date = date,
        image = imageUrl
    )
}