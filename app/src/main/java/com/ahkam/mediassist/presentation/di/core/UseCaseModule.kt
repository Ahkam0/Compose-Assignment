package com.ahkam.mediassist.presentation.di.core

import com.ahkam.mediassist.domain.repository.ProblemRepository
import com.ahkam.mediassist.domain.usecase.GetProblemsUseCase
import com.ahkam.mediassist.domain.usecase.UpdateProblemsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetProblemUseCase(problemRepository: ProblemRepository): GetProblemsUseCase {
        return GetProblemsUseCase(problemRepository)
    }

    @Provides
    fun provideUpdateProblemUseCase(problemRepository: ProblemRepository): UpdateProblemsUseCase {
        return UpdateProblemsUseCase(problemRepository)
    }

}