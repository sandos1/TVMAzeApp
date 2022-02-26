package com.sandona.tvmazeapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(

    val id: Int?,
    val imageUrl: String?,
    val name: String?,
    val language: String?,
    val type: String?
) : Parcelable

data class MovieDetails(
    val imageUrl: String?,
    val name: String?,
    val language: String?,
    val genre: String?
)

