package com.rim.data.remote

import com.rim.data.remote.common.PATH_MOVIES
import com.rim.domain.models.dao.response.EMoviesResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
interface ApiServices {
    @GET(PATH_MOVIES)
    suspend fun getAllMovies(): Response<EMoviesResponse>
}