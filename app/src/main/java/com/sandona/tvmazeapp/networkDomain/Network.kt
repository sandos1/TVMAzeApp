package com.sandona.tvmazeapp.networkDomain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Network(
    @Json(name = "country")
    val country: Country?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?
)
