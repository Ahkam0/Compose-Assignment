package com.ahkam.mediassist.data.api

import com.ahkam.mediassist.BuildConfig
import com.ahkam.mediassist.data.model.ProblemsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MediService {
    @GET("v3/" + BuildConfig.API_KEY)
    suspend fun getProblemsList(
    ): Response<ProblemsResponse>
}