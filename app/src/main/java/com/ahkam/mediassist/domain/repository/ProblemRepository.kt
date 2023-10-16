package com.ahkam.mediassist.domain.repository

import com.ahkam.mediassist.data.model.ProblemsResponse

interface ProblemRepository {
    suspend fun getProblems(): List<ProblemsResponse.Problems>?
    suspend fun updateProblems(): List<ProblemsResponse.Problems>?
}