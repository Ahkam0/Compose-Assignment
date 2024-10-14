//package com.ahkam.mediassist.presentation.di
//
//import com.ahkam.mediassist.domain.usecase.GetProblemsUseCase
//import com.ahkam.mediassist.domain.usecase.UpdateProblemsUseCase
//import com.ahkam.mediassist.presentation.viewmodel.ProblemViewModelFactory
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ActivityComponent
//import dagger.hilt.android.scopes.ActivityScoped
//
//@Module
//@InstallIn(ActivityComponent::class)
//class ProblemModule {
//    @ActivityScoped
//    @Provides
//    fun provideProblemViewModelFactory(
//        getProblemsUseCase: GetProblemsUseCase,
//        updateProblemsUseCase: UpdateProblemsUseCase
//    ): ProblemViewModelFactory {
//        return ProblemViewModelFactory(
//            getProblemsUseCase,
//            updateProblemsUseCase
//        )
//    }
//
//}