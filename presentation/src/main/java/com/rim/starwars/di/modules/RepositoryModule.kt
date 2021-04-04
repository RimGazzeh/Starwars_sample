package com.rim.starwars.di.modules

import com.rim.data.remote.ApiServices
import com.rim.data.remote.datasource.MoviesRemoteDataSourceImpl
import com.rim.data.remote.repositories.MoviesRepositoryImpl
import com.rim.domain.datasources.IMoviesDataSource
import com.rim.domain.repositories.IMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDataSource(apiServices: ApiServices): IMoviesDataSource {
        return MoviesRemoteDataSourceImpl(apiServices)
    }

    @Provides
    @Singleton
    fun provideRepository(moviesDataSource: IMoviesDataSource): IMovieRepository {
        return MoviesRepositoryImpl(moviesDataSource)
    }

}