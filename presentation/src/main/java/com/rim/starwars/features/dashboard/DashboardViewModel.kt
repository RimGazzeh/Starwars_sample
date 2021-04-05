package com.rim.starwars.features.dashboard

import androidx.lifecycle.MutableLiveData
import com.rim.domain.common.CallResult
import com.rim.domain.models.entities.Movie
import com.rim.domain.usecases.GetMoviesUseCase
import com.rim.starwars.base.BaseViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
class DashboardViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
    BaseViewModel() {

    private val _moviesResult = MutableLiveData<CallResult<List<Movie>>>()
    val moviesResult get() = _moviesResult

    fun getMovies() {
        launchOnUI {
            getMoviesUseCase().collect { _moviesResult.postValue(it) }
        }
    }
}