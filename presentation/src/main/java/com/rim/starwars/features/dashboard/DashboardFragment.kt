package com.rim.starwars.features.dashboard

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.rim.domain.common.CallResult
import com.rim.domain.common.fold
import com.rim.domain.models.entities.Movie
import com.rim.starwars.R
import com.rim.starwars.StarWarsApplication
import com.rim.starwars.base.BaseViewModelFragment
import com.rim.starwars.common.MOVIE_DETAIL_DATA
import com.rim.starwars.common.getErrorMsg
import com.rim.starwars.databinding.FragmentDashboardBinding
import com.rim.starwars.features.dashboard.adapter.MovieAdapter

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
class DashboardFragment : BaseViewModelFragment<DashboardViewModel>(R.layout.fragment_dashboard) {

    override val mViewModel: DashboardViewModel by injectViewModel()
    private val mBinding by viewBinding(FragmentDashboardBinding::bind)
    private val mMovieAdapter = MovieAdapter(this::onMovieClickAction)

    override fun intView() {
        initDI()
        initUI()
        initObservers()
        initData()
    }

    private fun initDI() {
        StarWarsApplication.appComponent.inject(this)
    }

    private fun initUI() {
        mBinding.dashboardMoviesList.adapter = mMovieAdapter
    }

    private fun initObservers() {
        mViewModel.moviesResult.observe(viewLifecycleOwner, { result ->
            mBinding.dashboardMoviesLoading.isVisible = result is CallResult.Loading
            mBinding.dashboardMoviesErrorMsg.isVisible = result is CallResult.Error
            result.fold(
                onSuccess = {
                    mMovieAdapter.setData(it)
                }, onError = {
                    mBinding.dashboardMoviesErrorMsg.text = it.getErrorMsg(requireContext())
                }
            )
        })
    }

    private fun initData() {
        mViewModel.getMovies()
    }

    private fun onMovieClickAction(movie: Movie) {
        Bundle().apply {
            putSerializable(MOVIE_DETAIL_DATA, movie)
            findNavController().navigate(R.id.action_dashboardFragment_to_movieDetailFragment, this)
        }
    }
}