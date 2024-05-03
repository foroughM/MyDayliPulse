package com.forough.mydailypulse.source.data

import com.forough.mydailypulse.source.application.Source
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceRaw(
    val id: String,
    val name: String,
    @SerialName("description")
    val desc: String?,
    val url: String?,
    val category: String?,
    val language: String,
    val country: String
)

fun SourceRaw.toSource(): Source = Source(
    this.id,
    this.name,
    this.desc,
    this.url,
    this.category,
    this.language,
    this.country
)
