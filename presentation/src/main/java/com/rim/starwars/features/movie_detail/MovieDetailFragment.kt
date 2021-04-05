package com.rim.starwars.features.movie_detail

import androidx.navigation.fragment.findNavController
import com.rim.domain.models.entities.Movie
import com.rim.starwars.R
import com.rim.starwars.base.BaseFragment
import com.rim.starwars.common.DateHelpers
import com.rim.starwars.common.MOVIE_DETAIL_DATA
import com.rim.starwars.databinding.FragmentMovieDetailBinding

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
class MovieDetailFragment : BaseFragment(R.layout.fragment_movie_detail) {

    private val mBinding by viewBinding(FragmentMovieDetailBinding::bind)
    private lateinit var mMovie: Movie

    override fun intView() {
        initData()
        initUI()
        initEvent()
    }

    private fun initData() {
        arguments?.getSerializable(MOVIE_DETAIL_DATA)?.let {
            mMovie = it as Movie
        } ?: kotlin.run {
            findNavController().popBackStack()
        }
    }

    private fun initUI() {
        mBinding.movieDetailToolbar.setToolbarTitle(mMovie.title)
        mBinding.movieDetailHeaderContainer.apply {
            movieDetailHeaderTitle.text = mMovie.title
            movieDetailHeaderReleaseDate.text = DateHelpers.releaseDateFormat(mMovie.releaseDate)
            movieDetailHeaderDirector.text = mMovie.director
            movieDetailHeaderProducer.text = mMovie.producer
        }
        mBinding.movieDetailDescriptionContainer.apply {
            movieDetailContentDescription.text = mMovie.openingCrawl
            movieDetailContentCreated.text = DateHelpers.movieEditDateFormat(mMovie.created)
            movieDetailContentEdited.text = DateHelpers.movieEditDateFormat(mMovie.edited)
        }
    }

    private fun initEvent() {
        mBinding.movieDetailToolbar.setOnBackClickListener {
            findNavController().popBackStack()
        }
    }
}