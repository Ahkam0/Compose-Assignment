package com.ahkam.mediassist.presentation.di.core

import com.ahkam.mediassist.BuildConfig
import com.ahkam.mediassist.data.api.MediService
import com.ahkam.mediassist.data.repository.datasource.ProblemRemoteDatasource
import com.ahkam.mediassist.data.repository.datasourceImpl.ProblemRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(mediService: MediService): ProblemRemoteDatasource {
        return ProblemRemoteDataSourceImpl(
            mediService, BuildConfig.API_KEY
        )
    }

}