package com.ahkam.mediassist.presentation.composables

import com.ahkam.mediassist.data.model.ProblemsResponse

data class DetailsUiState(
    val asthama: ProblemsResponse.Asthma? = null,
    val diabetes: ProblemsResponse.Diabetes? = null
)