package com.firsttask.itransition.dagger

import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.repository.FirstViewModelRepository
import com.firsttask.itransition.repository.SecondViewModelRepository
import com.firsttask.itransition.viewModel.viewModelFactory.FirstViewModelFactory
import com.firsttask.itransition.viewModel.viewModelFactory.SecondFragmentViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class VMFactoryModule{
    @Provides
    @Singleton
    fun getSecondVMFactory(secondViewModelRepository: SecondViewModelRepository, resourceProvider: ResourceProvider): SecondFragmentViewModelFactory{
        return SecondFragmentViewModelFactory(secondViewModelRepository , resourceProvider)
    }
    @Provides
    @Singleton
    fun getFirstVMFactory(firstViewModelRepository: FirstViewModelRepository): FirstViewModelFactory {
        return FirstViewModelFactory(firstViewModelRepository)
    }
}