package com.rim.domain.repositories

import com.rim.domain.common.CallResult
import com.rim.domain.models.entities.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
interface IMovieRepository {
    suspend fun getMovies(): Flow<CallResult<List<Movie>>>
}