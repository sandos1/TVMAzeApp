package com.sandona.tvmazeapp.networkDomain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rating(
    @Json(name = "average")
    val average: Double?
)
