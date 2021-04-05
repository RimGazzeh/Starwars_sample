package com.rim.data.repositories

import com.google.common.truth.Truth
import com.rim.data.base.MockServerTest
import com.rim.data.remote.datasource.MoviesRemoteDataSourceImpl
import com.rim.data.remote.repositories.MoviesRepositoryImpl
import com.rim.domain.common.CallResult
import com.rim.domain.datasources.IMoviesDataSource
import com.rim.domain.repositories.IMovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
open class MoviesRepositoryImplTest : MockServerTest() {
     private lateinit var mMoviesDataSource: IMoviesDataSource
     private lateinit var mMoviesRepository: IMovieRepository

    @Before
    override fun startMockServer() {
        super.startMockServer()
        mMoviesDataSource = MoviesRemoteDataSourceImpl(mApiServices)
        mMoviesRepository = MoviesRepositoryImpl(mMoviesDataSource)
    }

    @Test
    fun testAllMoviesData() {
        runBlocking {
            val moviesFlow = mMoviesRepository.getMovies()
            moviesFlow.collect { result ->
                if(result is CallResult.Success){
                    Truth.assertThat(result.data.size).isEqualTo(4)
                    Truth.assertThat(result.data[0].title).matches("A New Hope")
                    Truth.assertThat(result.data[2].director).matches("Richard Marquand")
                }
            }
        }
    }
}