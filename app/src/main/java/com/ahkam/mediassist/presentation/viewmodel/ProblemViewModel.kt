package com.ahkam.mediassist.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ahkam.mediassist.domain.usecase.GetProblemsUseCase
import com.ahkam.mediassist.domain.usecase.UpdateProblemsUseCase
import kotlinx.coroutines.flow.flow

class ProblemViewModel(
    private val getProblemsUseCase: GetProblemsUseCase,
    private val updateProblemsUseCase: UpdateProblemsUseCase
) : ViewModel() {

    fun getProblems() = flow {
        Log.i("TAG", "view model getProblems")
        val problemsList = getProblemsUseCase.execute()
        emit(problemsList)
    }

    fun updateProblems() = flow {
        val problemsList = updateProblemsUseCase.execute()
        emit(problemsList)
    }

}