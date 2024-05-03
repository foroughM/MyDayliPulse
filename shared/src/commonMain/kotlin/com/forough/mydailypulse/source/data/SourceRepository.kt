package com.forough.mydailypulse.source.data

class SourceRepository(
    private val service: SourceService,
    private val datasource: SourceDatasource
) {

    suspend fun getAllSources(): List<SourceRaw> {
        val sourcesDb = datasource.getAllSources()
        if (sourcesDb.isEmpty()) {
            val fetchedSources = service.getSources()
            datasource.insertSources(fetchedSources)
            return fetchedSources
        }
        return sourcesDb
    }
}