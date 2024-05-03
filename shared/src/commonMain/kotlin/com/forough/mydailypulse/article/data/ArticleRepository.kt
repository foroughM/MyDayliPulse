package com.forough.mydailypulse.article.data

class ArticleRepository(
    private val service: ArticleService,
    private val dataSource: ArticlesDataSource
) {

    suspend fun getArticles(isForce: Boolean): List<ArticleRaw> {

        if (isForce) {
            val fetchedArticles = service.fetchArticles()
            dataSource.clearArticles()
            dataSource.insertAllArticles(fetchedArticles)
            return fetchedArticles
        }

        val articlesDb = dataSource.getAllArticles()
        if (articlesDb.isEmpty()) {
            val fetchedArticles = service.fetchArticles()
            dataSource.insertAllArticles(fetchedArticles)
            return fetchedArticles
        }
        return articlesDb
    }


}