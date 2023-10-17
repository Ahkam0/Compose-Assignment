package com.ahkam.mediassist.presentation.composables

import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahkam.mediassist.MainActivity
import com.ahkam.mediassist.R
import com.ahkam.mediassist.presentation.viewmodel.ProblemViewModel
import com.ahkam.mediassist.ui.theme.Blue800
import com.ahkam.mediassist.ui.theme.Dark
import com.ahkam.mediassist.ui.theme.Gray200
import com.ahkam.mediassist.ui.theme.LoginGray
import com.ahkam.mediassist.ui.theme.popinsFamily
import com.ahkam.mediassist.utils.DateTimeUtilityJava
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.jvm.internal.Intrinsics.Kotlin

@Composable
fun HomeScreen(
    navController: NavHostController,
    problemViewModel: ProblemViewModel = hiltViewModel(),
) {

    val coroutineScope = rememberCoroutineScope()
    val activity = LocalContext.current as MainActivity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Header(
            activity.myUserName.ifEmpty {
                "Anonymous"
            }
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {


        }
    }
}


@Composable
fun Header(value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(94.dp)
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    ImageView(context).apply {
                        setBackgroundResource(R.drawable.bg_home_appbar)
                    }
                }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(0.dp, 0.dp, 15.dp, 18.dp)
            ) {

                IconButton(
                    onClick = {
                    }, modifier = Modifier.size(29.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_search_home),
                        contentDescription = "None",
                        tint = Color.Unspecified, modifier = Modifier.padding(0.dp)
                    )

                }

                Spacer(modifier = Modifier.width(6.dp))

            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp, 20.dp, 5.dp, 0.dp)
        ) {
            Text(
                fontSize = 35.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = popinsFamily,
                overflow = TextOverflow.Ellipsis,
                text = stringResource(id = R.string.greetings),
                textAlign = TextAlign.Start,
                maxLines = 1,
                color = Dark,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    ),
                )
            )

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = popinsFamily,
                overflow = TextOverflow.Ellipsis,
                text = "$value!",
                textAlign = TextAlign.Start,
                maxLines = 1,
                color = LoginGray,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    ),
                )
            )

        }

        Text(
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = popinsFamily,
            overflow = TextOverflow.Ellipsis,
            text = DateTimeUtilityJava.getDate(System.currentTimeMillis()) + " | " +
                    DateTimeUtilityJava.getTime(System.currentTimeMillis()),
            textAlign = TextAlign.Start,
            maxLines = 1,
            color = Gray200,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp, 7.dp, 5.dp, 0.dp)
        )

        Text(
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = popinsFamily,
            overflow = TextOverflow.Ellipsis,
            text = stringResource(id = R.string.doses),
            textAlign = TextAlign.Center,
            maxLines = 1,
            color = Blue800,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        )
    }
}