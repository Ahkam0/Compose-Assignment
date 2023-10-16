package com.ahkam.mediassist.presentation.di.core

import com.ahkam.mediassist.data.db.ProblemsDAO
import com.ahkam.mediassist.data.repository.datasource.ProblemLocalDataSource
import com.ahkam.mediassist.data.repository.datasourceImpl.ProblemLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(problemsDAO: ProblemsDAO): ProblemLocalDataSource {
        return ProblemLocalDataSourceImpl(problemsDAO)
    }

}