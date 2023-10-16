package com.ahkam.mediassist.domain.usecase

import com.ahkam.mediassist.data.model.ProblemsResponse
import com.ahkam.mediassist.domain.repository.ProblemRepository

class GetProblemsUseCase(private val problemRepository: ProblemRepository) {
    suspend fun execute(): List<ProblemsResponse.Problems>? = problemRepository.getProblems()

}