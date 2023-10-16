package com.ahkam.mediassist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahkam.mediassist.domain.usecase.GetProblemsUseCase
import com.ahkam.mediassist.domain.usecase.UpdateProblemsUseCase

class ProblemViewModelFactory(
    private val getProblemsUseCase: GetProblemsUseCase,
    private val updateProblemsUseCase: UpdateProblemsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProblemViewModel(
            getProblemsUseCase,
            updateProblemsUseCase
        ) as T
    }
}