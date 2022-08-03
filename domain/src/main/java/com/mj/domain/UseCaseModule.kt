package com.mj.domain

import com.mj.domain.usecase.CollectMealPlanChangeEventUseCase
import com.mj.domain.usecase.WriteMealPlanUseCase
import com.mj.firebase.FirebaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideWriteMealPlanUseCase(repository: FirebaseRepository) = WriteMealPlanUseCase(repository)

    @Provides
    @Singleton
    fun provideCollectMealPlanChangeEventUseCase(repository: FirebaseRepository) = CollectMealPlanChangeEventUseCase(repository)
}