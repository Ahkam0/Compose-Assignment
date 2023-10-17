package com.ahkam.mediassist.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ahkam.mediassist.domain.usecase.GetProblemsUseCase
import com.ahkam.mediassist.domain.usecase.UpdateProblemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class ProblemViewModel @Inject constructor(
    private val getProblemsUseCase: GetProblemsUseCase,
    private val updateProblemsUseCase: UpdateProblemsUseCase
) : ViewModel() {

    val username: MutableState<String> = mutableStateOf("Anonymous")
    val password: MutableState<String> = mutableStateOf("")


    fun getProblems() = flow {
        Log.i("TAG", "view model getProblems")
        val problemsList = getProblemsUseCase.execute()
        emit(problemsList)
    }

    fun updateProblems() = flow {
        val problemsList = updateProblemsUseCase.execute()
        emit(problemsList)
    }

    fun setUsername(value: String) {
        username.value = value
    }

    fun setPassword(value: String) {
        password.value = value
    }

}