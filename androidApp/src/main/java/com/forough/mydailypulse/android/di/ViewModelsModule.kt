package com.forough.mydailypulse.android.di

import com.forough.mydailypulse.article.presentation.ArticlesViewModel
import com.forough.mydailypulse.source.presentation.SourceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
    viewModel { SourceViewModel(get()) }
}