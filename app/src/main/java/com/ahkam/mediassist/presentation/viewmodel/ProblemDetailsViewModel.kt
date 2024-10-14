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
import com.ahkam.mediassist.presentation.composables.DetailsUiState
import com.ahkam.mediassist.presentation.composables.HomeUiState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class ProblemDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel()
{

    var uiState by mutableStateOf(DetailsUiState())
        private set

    private val asthamaObj
        get() = savedStateHandle.get<String>(DETAIL_OBJECT)

    private val diabetesObj
        get() = savedStateHandle.get<String>(DETAIL_OBJECT)


//    val asthama: ProblemsResponse.Asthma =
//        Gson().fromJson(asthamaObj, ProblemsResponse.Asthma::class.java)
//
//    val diabetes: ProblemsResponse.Diabetes =
//        Gson().fromJson(diabetesObj, ProblemsResponse.Diabetes::class.java)
//
//    init {
//        uiState = uiState.copy(asthama =  asthama)
//        uiState = uiState.copy(diabetes =  diabetes)
//    }

}