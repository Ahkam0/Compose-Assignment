package com.ahkam.mediassist.domain.usecase

import com.ahkam.mediassist.data.model.ProblemsResponse
import com.ahkam.mediassist.domain.repository.ProblemRepository

class UpdateProblemsUseCase(private val problemRepository: ProblemRepository) {
    suspend fun execute(): List<ProblemsResponse.Problems>? = problemRepository.updateProblems()
}