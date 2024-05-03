package com.forough.mydailypulse.source.di

import com.forough.mydailypulse.source.application.SourceUseCase
import com.forough.mydailypulse.source.data.SourceDatasource
import com.forough.mydailypulse.source.data.SourceRepository
import com.forough.mydailypulse.source.data.SourceService
import org.koin.dsl.module

val sourceModule = module {
    single { SourceService(get()) }
    single { SourceDatasource(get()) }
    single { SourceRepository(get(), get()) }
    single { SourceUseCase(get()) }
}