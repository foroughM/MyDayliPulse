package com.forough.mydailypulse.di

import com.forough.mydailypulse.article.di.articleModule
import com.forough.mydailypulse.source.di.sourceModule

val sharedKoinModule = listOf(
    articleModule,
    networkModule,
    sourceModule
)