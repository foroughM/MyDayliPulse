package com.forough.mydailypulse.source.presentation

import com.forough.mydailypulse.source.application.Source

data class SourcesState(
    val sources: List<Source> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
