package com.rim.starwars.di.modules

import androidx.lifecycle.ViewModelProvider
import com.rim.starwars.di.viewmodel.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}