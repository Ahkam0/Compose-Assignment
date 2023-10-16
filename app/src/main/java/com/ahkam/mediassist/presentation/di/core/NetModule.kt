package com.ahkam.mediassist.presentation.di.core

import com.ahkam.mediassist.data.api.MediService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule() {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("")
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit): MediService {
        return retrofit.create(MediService::class.java)
    }

}