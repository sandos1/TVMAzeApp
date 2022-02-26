package com.sandona.tvmazeapp.networkDomain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Externals(
    @Json(name = "imdb")
    val imdb: String?,
    @Json(name = "thetvdb")
    val thetvdb: Int?,
    @Json(name = "tvrage")
    val tvrage: Int?
)
