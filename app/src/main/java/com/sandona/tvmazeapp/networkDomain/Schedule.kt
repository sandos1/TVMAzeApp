package com.sandona.tvmazeapp.networkDomain


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Schedule(
    @Json(name = "days")
    val days: List<String>?,
    @Json(name = "time")
    val time: String?
)