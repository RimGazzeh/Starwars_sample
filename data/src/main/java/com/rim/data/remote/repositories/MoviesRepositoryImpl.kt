package com.rim.data.remote.repositories

import com.rim.data.remote.common.applyCommonSideEffects
import com.rim.domain.common.CallResult
import com.rim.domain.datasources.IMoviesDataSource
import com.rim.domain.models.entities.Movie
import com.rim.domain.repositories.IMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
class MoviesRepositoryImpl(private val dataSource: IMoviesDataSource) : IMovieRepository {
    override suspend fun getMovies(): Flow<CallResult<List<Movie>>> = flow {
        emit(dataSource.getMovies())
    }.applyCommonSideEffects()
}