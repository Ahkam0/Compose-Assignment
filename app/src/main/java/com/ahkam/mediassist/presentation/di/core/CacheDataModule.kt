package com.ahkam.mediassist.presentation.di.core

import com.ahkam.mediassist.data.repository.datasource.ProblemCacheDataSource
import com.ahkam.mediassist.data.repository.datasourceImpl.ProblemCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {
    @Singleton
    @Provides
    fun provideProblemCacheDataSource(): ProblemCacheDataSource {
        return ProblemCacheDataSourceImpl()
    }

}