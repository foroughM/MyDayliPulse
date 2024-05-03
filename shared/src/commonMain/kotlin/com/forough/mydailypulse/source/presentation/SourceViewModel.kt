package com.forough.mydailypulse.source.presentation

import com.forough.mydailypulse.BaseViewModel
import com.forough.mydailypulse.source.application.SourceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SourceViewModel(
    private val sourceUseCase: SourceUseCase
) : BaseViewModel() {

    private val _sourcesState: MutableStateFlow<SourcesState> =
        MutableStateFlow(SourcesState(isLoading = true))
    val sourcesState: StateFlow<SourcesState> = _sourcesState.asStateFlow()

    init {
        getSources()
    }

    private fun getSources() {
        scope.launch {
            _sourcesState.emit(
                SourcesState(
                    isLoading = true,
                    sources = _sourcesState.value.sources
                )
            )
            val fetchedSources = sourceUseCase.getAllSources()
            _sourcesState.emit(SourcesState(sources = fetchedSources))
        }
    }
}