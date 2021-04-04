package com.rim.starwars.di.component

import com.rim.starwars.di.modules.NetworkModule
import com.rim.starwars.di.modules.RepositoryModule
import com.rim.starwars.di.modules.UseCasesModule
import com.rim.starwars.di.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
@Singleton
@Component(
    modules = [ViewModelModule::class, RepositoryModule::class, NetworkModule::class, UseCasesModule::class]
)
interface AppComponent