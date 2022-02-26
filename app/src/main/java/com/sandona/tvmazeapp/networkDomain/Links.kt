package com.sandona.tvmazeapp.networkDomain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "previousepisode")
    val previousepisode: Previousepisode?,
    @Json(name = "self")
    val self: Self?
)
