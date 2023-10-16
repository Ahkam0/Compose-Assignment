package com.ahkam.mediassist.data.repository.datasource

import com.ahkam.mediassist.data.model.ProblemsResponse
import retrofit2.Response

interface ProblemRemoteDatasource {
    suspend fun getProblems(): Response<ProblemsResponse>
}