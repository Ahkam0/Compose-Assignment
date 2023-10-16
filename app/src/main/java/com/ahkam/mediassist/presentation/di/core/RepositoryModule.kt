package com.ahkam.mediassist.presentation.di.core

import com.ahkam.mediassist.data.repository.ProblemRepositoryImpl
import com.ahkam.mediassist.data.repository.datasource.ProblemCacheDataSource
import com.ahkam.mediassist.data.repository.datasource.ProblemLocalDataSource
import com.ahkam.mediassist.data.repository.datasource.ProblemRemoteDatasource
import com.ahkam.mediassist.domain.repository.ProblemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        problemRemoteDatasource: ProblemRemoteDatasource,
        problemLocalDataSource: ProblemLocalDataSource,
        problemCacheDataSource: ProblemCacheDataSource
    ): ProblemRepository {

        return ProblemRepositoryImpl(
            problemRemoteDatasource,
            problemLocalDataSource,
            problemCacheDataSource
        )
    }

}