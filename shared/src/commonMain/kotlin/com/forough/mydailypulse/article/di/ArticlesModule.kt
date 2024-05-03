package com.forough.mydailypulse.article.di

import com.forough.mydailypulse.article.data.ArticleRepository
import com.forough.mydailypulse.article.data.ArticleService
import com.forough.mydailypulse.article.application.ArticleUseCase
import com.forough.mydailypulse.article.data.ArticlesDataSource
import com.forough.mydailypulse.article.presentation.ArticlesViewModel
import org.koin.dsl.module

val articleModule = module {

    single { ArticleService(get()) }
    single { ArticleUseCase(get()) }
    single { ArticlesViewModel(get()) }
    single { ArticlesDataSource(get()) }
    single { ArticleRepository(get(), get()) }
}