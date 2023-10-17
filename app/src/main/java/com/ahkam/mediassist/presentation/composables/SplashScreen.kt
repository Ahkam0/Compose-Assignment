package com.ahkam.mediassist.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahkam.mediassist.R
import com.airbnb.lottie.compose.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ahkam.mediassist.destinations.LoginDestination
import com.ahkam.mediassist.destinations.SplashDestination
import com.ahkam.mediassist.ui.theme.Dark
import com.ahkam.mediassist.ui.theme.popinsFamily
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavHostController) {

    val coroutineScope = rememberCoroutineScope()

    var isPlaying by remember {
        mutableStateOf(true)
    }

    var speed by remember {
        mutableStateOf(1f)
    }

    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.animation)
    )


    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = false
    )

    // Column Composable
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(
            composition,
            progress,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
        )


        Text(
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = popinsFamily,
            overflow = TextOverflow.Ellipsis,
            text = stringResource(id = R.string.app_name),
            textAlign = TextAlign.Center,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(alignment = Alignment.CenterHorizontally),
            color = Dark,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                ),
            )
        )

        LaunchedEffect(navController) {
            coroutineScope.launch {
                delay(3000)
                navController.navigate(LoginDestination.route()) {
                    popUpTo(SplashDestination.route()) {
                        inclusive = true
                    }
                }
            }
        }

    }
}
