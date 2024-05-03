package com.forough.mydailypulse.source.application

import com.forough.mydailypulse.source.data.SourceRepository
import com.forough.mydailypulse.source.data.toSource

class SourceUseCase(
    private val repository: SourceRepository
) {
    suspend fun getAllSources(): List<Source> {
        return repository.getAllSources().map { it.toSource() }
    }
}