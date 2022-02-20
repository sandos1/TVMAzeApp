package com.sandona.tvmazeapp.networkDomain


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Previousepisode(
    @Json(name = "href")
    val href: String?
)