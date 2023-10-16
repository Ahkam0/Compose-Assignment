package com.ahkam.mediassist.data.repository.datasource

import com.ahkam.mediassist.data.model.ProblemsResponse


interface ProblemCacheDataSource {
    suspend fun getProblemsFromCache(): List<ProblemsResponse.Problems>
    suspend fun saveProblemsToCache(problems: List<ProblemsResponse.Problems>)

}