package com.sandona.tvmazeapp.di


import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class MapperModule {

//    @Binds
//    abstract fun provideMovieMapper(movieMapper: MovieMapper): BaseMapper<Movie2NetworkResponse, MovieResponse>
}
