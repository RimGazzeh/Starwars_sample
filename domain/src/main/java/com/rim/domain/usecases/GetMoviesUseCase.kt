package com.rim.domain.usecases

import com.rim.domain.common.CallResult
import com.rim.domain.models.entities.Movie
import com.rim.domain.repositories.IMovieRepository
import com.rim.domain.usecases.base.BaseUseCase
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
class GetMoviesUseCase(private val movieRepository: IMovieRepository) :
    BaseUseCase<Flow<CallResult<List<Movie>>>> {
    override suspend fun invoke(): Flow<CallResult<List<Movie>>> {
        return movieRepository.getMovies()
    }
}