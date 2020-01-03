package com.firsttask.itransition.dagger

import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.repository.ViewModelRepository
import com.firsttask.itransition.viewModel.viewModelFactory.SecondFragmentViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class VMFactoryModule{
    @Provides
    @Singleton
    fun getVMFactory(viewModelRepository: ViewModelRepository ,resourceProvider: ResourceProvider): SecondFragmentViewModelFactory{
        return SecondFragmentViewModelFactory(viewModelRepository , resourceProvider)
    }
}