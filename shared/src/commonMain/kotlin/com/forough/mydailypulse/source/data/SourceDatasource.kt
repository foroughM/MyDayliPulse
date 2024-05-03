package com.forough.mydailypulse.source.data

import com.forough.mydailypulse.db.MyDailyPulseDatabase

class SourceDatasource(
    private val database: MyDailyPulseDatabase
) {
    fun getAllSources(): List<SourceRaw> {
        return database.myDailyPulseDatabaseQueries.selectSources(::mapToSourceRaw).executeAsList()
    }

    fun insertSources(sources: List<SourceRaw>) {
        database.myDailyPulseDatabaseQueries.transaction {
            sources.forEach { sourceRaw ->
                insertSource(sourceRaw)
            }
        }
    }

    private fun insertSource(sourceRaw: SourceRaw) {
        database.myDailyPulseDatabaseQueries.insertSource(
            sourceRaw.id,
            sourceRaw.name,
            sourceRaw.desc,
            sourceRaw.url,
            sourceRaw.category,
            sourceRaw.language,
            sourceRaw.country
        )
    }

    private fun mapToSourceRaw(
        id: String,
        name: String,
        desc: String?,
        url: String?,
        category: String?,
        language: String,
        country: String
    ): SourceRaw = SourceRaw(
        id,
        name,
        desc,
        url,
        category,
        language,
        country
    )
}