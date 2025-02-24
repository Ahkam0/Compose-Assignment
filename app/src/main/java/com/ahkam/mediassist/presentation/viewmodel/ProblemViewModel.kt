package com.ahkam.mediassist.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ahkam.mediassist.data.model.ProblemsResponse
import com.ahkam.mediassist.destinations.DetailDestination.DETAIL_OBJECT
import com.ahkam.mediassist.destinations.HomeDestination.HOME_OBJECT
import com.ahkam.mediassist.domain.usecase.GetProblemsUseCase
import com.ahkam.mediassist.domain.usecase.UpdateProblemsUseCase
import com.ahkam.mediassist.presentation.composables.HomeUiState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class ProblemViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getProblemsUseCase: GetProblemsUseCase,
    private val updateProblemsUseCase: UpdateProblemsUseCase
) : ViewModel()
{

    var uiState by mutableStateOf(HomeUiState())
        private set

    private val username
        get() = savedStateHandle.get<String>(HOME_OBJECT)
            ?: throw IllegalStateException("Parameter homeObject must not be null!")


    init {
        uiState = uiState.copy(userName =  username)
    }

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