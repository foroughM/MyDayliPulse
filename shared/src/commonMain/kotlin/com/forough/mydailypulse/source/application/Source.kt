package com.forough.mydailypulse.source.application

data class Source(
    val id: String,
    val name: String,
    val desc: String?,
    val url: String?,
    val category: String?,
    val language: String,
    val country: String
)
