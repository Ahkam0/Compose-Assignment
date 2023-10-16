package com.ahkam.mediassist.data.repository.datasourceImpl

import com.ahkam.mediassist.data.api.MediService
import com.ahkam.mediassist.data.model.ProblemsResponse
import com.ahkam.mediassist.data.repository.datasource.ProblemRemoteDatasource
import retrofit2.Response

class ProblemRemoteDataSourceImpl(
    private val mediService: MediService
) : ProblemRemoteDatasource {
    override suspend fun getProblems(): Response<ProblemsResponse> =
        mediService.getProblemsList()
}