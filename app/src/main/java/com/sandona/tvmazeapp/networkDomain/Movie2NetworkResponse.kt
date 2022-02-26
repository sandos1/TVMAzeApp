package com.sandona.tvmazeapp.networkDomain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie2NetworkResponse(
    @Json(name = "averageRuntime")
    val averageRuntime: Int?,
    @Json(name = "dvdCountry")
    val dvdCountry: Any?,
    @Json(name = "ended")
    val ended: String?,
    @Json(name = "externals")
    val externals: Externals?,
    @Json(name = "genres")
    val genres: List<String>?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: Image?,
    @Json(name = "language")
    val language: String?,
    @Json(name = "_links")
    val links: Links?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "network")
    val network: Network?,
    @Json(name = "officialSite")
    val officialSite: String?,
    @Json(name = "premiered")
    val premiered: String?,
    @Json(name = "rating")
    val rating: Rating?,
    @Json(name = "runtime")
    val runtime: Int?,
    @Json(name = "schedule")
    val schedule: Schedule?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "updated")
    val updated: Int?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "webChannel")
    val webChannel: Any?,
    @Json(name = "weight")
    val weight: Int?
)
