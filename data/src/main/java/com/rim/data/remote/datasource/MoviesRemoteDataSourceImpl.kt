package com.rim.data.remote.datasource

import com.rim.data.remote.ApiServices
import com.rim.data.remote.common.getResult
import com.rim.domain.common.CallResult
import com.rim.domain.datasources.IMoviesDataSource
import com.rim.domain.models.dao.response.toEntity
import com.rim.domain.models.entities.Movie

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
class MoviesRemoteDataSourceImpl(private val apiServices: ApiServices) : IMoviesDataSource {
    override suspend fun getMovies(): CallResult<List<Movie>> =
        apiServices.getAllMovies().run { this.getResult { this.result.toEntity() } }
}