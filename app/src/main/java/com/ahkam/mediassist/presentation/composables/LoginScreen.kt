package com.ahkam.mediassist.presentation.composables


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahkam.mediassist.presentation.viewmodel.ProblemViewModel


@Composable
fun LoginScreen(
    navController: NavHostController,
    problemViewModel: ProblemViewModel = hiltViewModel()
) {


    DetailScreen()

}