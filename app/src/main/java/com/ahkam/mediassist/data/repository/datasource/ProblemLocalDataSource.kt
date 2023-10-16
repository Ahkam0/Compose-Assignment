package com.ahkam.mediassist.data.repository.datasource

import com.ahkam.mediassist.data.model.ProblemsResponse

interface ProblemLocalDataSource {
    suspend fun getProblemsFromDB(): List<ProblemsResponse.Problems>
    suspend fun saveProblemsToDB(problems: List<ProblemsResponse.Problems>)
    suspend fun clearAll()
}