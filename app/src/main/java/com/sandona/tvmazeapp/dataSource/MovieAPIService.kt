package com.sandona.tvmazeapp.dataSource

import com.sandona.tvmazeapp.domain.model.MovieResponse
import com.sandona.tvmazeapp.utils.Constant.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface MovieAPIService {

    @GET(END_POINT)
    suspend fun getShowList(): Response<List<MovieResponse>>
}
