package com.rim.domain.datasources

import com.rim.domain.common.CallResult
import com.rim.domain.models.entities.Movie

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
interface IMoviesDataSource {
    suspend fun getMovies(): CallResult<List<Movie>>
}