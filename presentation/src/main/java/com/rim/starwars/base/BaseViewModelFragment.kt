package com.rim.starwars.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.rim.starwars.di.viewmodel.DaggerViewModelFactory
import javax.inject.Inject

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
abstract class BaseViewModelFragment<out T : BaseViewModel> (@LayoutRes layoutId: Int) : BaseFragment(layoutId){
    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    protected abstract val viewModel: T?
    protected inline fun <reified VM : ViewModel> injectViewModel(): Lazy<VM> =
        activityViewModels { viewModelFactory }
}