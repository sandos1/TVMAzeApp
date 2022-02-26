package com.sandona.tvmazeapp.di

import com.sandona.tvmazeapp.dataSource.MovieAPIService
import com.sandona.tvmazeapp.domain.mapper.BaseMapper
import com.sandona.tvmazeapp.domain.mapper.MovieMapper
import com.sandona.tvmazeapp.domain.model.MovieResponse
import com.sandona.tvmazeapp.networkDomain.Movie2NetworkResponse
import com.sandona.tvmazeapp.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MovieModule {

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideAPiService(BASE_URL: String) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create()) // Moshi
        .build()
        .create(MovieAPIService::class.java)

    @Provides
    fun provideMovieMapper():BaseMapper<Movie2NetworkResponse,MovieResponse> {
        return MovieMapper()
    }
}
