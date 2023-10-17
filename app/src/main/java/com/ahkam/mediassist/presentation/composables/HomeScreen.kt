package com.ahkam.mediassist.presentation.composables

import android.widget.ImageView
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahkam.mediassist.R
import com.ahkam.mediassist.presentation.viewmodel.ProblemViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    problemViewModel: ProblemViewModel = hiltViewModel()
) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Header()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {


        }
    }
}


@Composable
fun Header() {
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
}