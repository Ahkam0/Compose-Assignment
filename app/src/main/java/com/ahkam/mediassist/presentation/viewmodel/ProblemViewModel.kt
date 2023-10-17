package com.ahkam.mediassist.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ahkam.mediassist.domain.usecase.GetProblemsUseCase
import com.ahkam.mediassist.domain.usecase.UpdateProblemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class ProblemViewModel @Inject constructor(
    private val getProblemsUseCase: GetProblemsUseCase,
    private val updateProblemsUseCase: UpdateProblemsUseCase
) : ViewModel()
{

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