package com.rim.starwars.di.modules

import com.rim.domain.repositories.IMovieRepository
import com.rim.domain.usecases.GetMoviesUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Rim Gazzah on 4/4/21.
 **/

@Module
class UseCasesModule {

    @Provides
    fun provideGetAllMovies(movieRepository: IMovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
}