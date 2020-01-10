package com.firsttask.itransition.dagger

import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.repository.FirstViewModelRepository
import com.firsttask.itransition.repository.SecondFragmentOftwoFragmentViewModelRepository
import com.firsttask.itransition.repository.SecondViewModelRepository
import com.firsttask.itransition.viewModel.viewModelFactory.FirstViewModelFactory
import com.firsttask.itransition.viewModel.viewModelFactory.SecondFragmentOfTwoFragmentFactory
import com.firsttask.itransition.viewModel.viewModelFactory.SecondFragmentViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class VMFactoryModule{
    @Provides
    @Singleton
    fun getSecondVMFactory(secondViewModelRepository: SecondViewModelRepository, resourceProvider: ResourceProvider , appDatabase: AppDatabase): SecondFragmentViewModelFactory{
        return SecondFragmentViewModelFactory(secondViewModelRepository , resourceProvider , appDatabase)
    }
    @Provides
    @Singleton
    fun getFirstVMFactory(firstViewModelRepository: FirstViewModelRepository): FirstViewModelFactory {
        return FirstViewModelFactory(firstViewModelRepository)
    }
    @Provides
    @Singleton
    fun getSecondVMFactoryOfTwoFactory(secondFragmentOfTwoFragmentViewModelRepository: SecondFragmentOftwoFragmentViewModelRepository) :SecondFragmentOfTwoFragmentFactory{
        return getSecondVMFactoryOfTwoFactory(secondFragmentOfTwoFragmentViewModelRepository)
    }
}