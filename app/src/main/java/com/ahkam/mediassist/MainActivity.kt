package com.ahkam.mediassist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahkam.mediassist.destinations.DetailDestination
import com.ahkam.mediassist.destinations.HomeDestination
import com.ahkam.mediassist.destinations.LoginDestination
import com.ahkam.mediassist.destinations.SplashDestination
import com.ahkam.mediassist.navigation.Navigator
import com.ahkam.mediassist.navigation.NavigatorDestination
import com.ahkam.mediassist.navigation.NavigatorEvent
import com.ahkam.mediassist.presentation.composables.DetailScreen
import com.ahkam.mediassist.presentation.composables.HomeScreen
import com.ahkam.mediassist.presentation.composables.LoginScreen
import com.ahkam.mediassist.presentation.composables.SplashScreen
import com.ahkam.mediassist.ui.theme.MediAssistTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    var myUserName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            MediAssistTheme {
                LaunchedEffect(navController) {
                    navigator.destinations.collectLatest {
                        when (val event = it) {
                            is NavigatorEvent.NavigateUp -> navController.navigateUp()
                            is NavigatorEvent.PopBackStack -> navController.popBackStack()
                            is NavigatorEvent.Directions -> navController.navigate(
                                event.destination, event.builder
                            )
                        }
                    }
                }

                val composableDestinations: Map<NavigatorDestination, @Composable () -> Unit> =
                    mapOf(
                        SplashDestination to { SplashScreen(navController) },
                        LoginDestination to { LoginScreen(navController) },
                        HomeDestination to { HomeScreen(navController) },
                        DetailDestination to { DetailScreen() }
                    )

                NavHost(
                    navController = navController,
                    startDestination = SplashDestination.route()
                ) {
                    composableDestinations.forEach { entry ->
                        val destination = entry.key
                        composable(destination.route(), destination.arguments) { entry.value() }
                    }
                }
            }
        }
    }
}
