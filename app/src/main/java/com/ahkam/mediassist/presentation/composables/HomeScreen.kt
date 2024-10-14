package com.ahkam.mediassist.presentation.composables

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.ahkam.mediassist.data.model.ProblemsResponse
import com.ahkam.mediassist.destinations.DetailDestination
import com.ahkam.mediassist.destinations.HomeDestination
import com.ahkam.mediassist.destinations.LoginDestination
import com.ahkam.mediassist.presentation.viewmodel.ProblemViewModel
import com.ahkam.mediassist.ui.theme.Blue800
import com.ahkam.mediassist.ui.theme.Dark
import com.ahkam.mediassist.ui.theme.Gray200
import com.ahkam.mediassist.ui.theme.LoginGray
import com.ahkam.mediassist.ui.theme.popinsFamily
import com.ahkam.mediassist.utils.DateTimeUtilityJava
import com.google.gson.Gson

@Composable
fun HomeScreen(
    navController: NavHostController,
    problemViewModel: ProblemViewModel = hiltViewModel(),
) {

    val activity = LocalContext.current as MainActivity

    val prbList = problemViewModel.getProblems().collectAsState(initial = null).value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Header(
            problemViewModel.uiState.userName.ifEmpty {
                "Anonymous"
            }
        )

        Spacer(modifier = Modifier.size(20.dp))

        prbList?.let {
            DisplayDoses(
                probList = it as ArrayList<ProblemsResponse.Problems>,
                activity,
                navController
            )
        }

    }
}


@Composable
fun DisplayDoses(
    probList: ArrayList<ProblemsResponse.Problems>,
    activity: MainActivity,
    navController: NavHostController
) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 15.dp)) {
        items(
            items = probList,
            itemContent = { DosesItem(problem = it, activity, navController) })
    }

}

@Composable
fun DosesItem(
    problem: ProblemsResponse.Problems,
    activity: MainActivity,
    navController: NavHostController
) {
    problem.diabetes?.let {
        DiabetesItem(it) {
            activity.selectedD = it
            activity.selectedItem = true
            navController.navigate(DetailDestination.route())

        }
    }

    problem.asthma?.let {
        AsthemaItem(it) {
            activity.selectedA = it
            activity.selectedItem = false
            navController.navigate(DetailDestination.route())
        }
    }

}


@Composable
fun DiabetesItem(
    diabetes: List<ProblemsResponse.Diabetes>,
    onClick: (List<ProblemsResponse.Diabetes>) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .shadow(10.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {

        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable { onClick(diabetes) }, verticalAlignment = Alignment.CenterVertically
        ) {
            DoseShowImage(R.drawable.diabetes)
            Column() {
                Text(
                    text = stringResource(id = R.string.diabetes),
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = diabetes[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].name,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = diabetes[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].strength,
                        style = MaterialTheme.typography.titleSmall
                    )

                }

            }

        }

    }

}


@Composable
fun AsthemaItem(
    asthmas: List<ProblemsResponse.Asthma>,
    onClick: (List<ProblemsResponse.Asthma>) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .shadow(10.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {

        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable { onClick(asthmas) }, verticalAlignment = Alignment.CenterVertically
        ) {
            DoseShowImage(R.drawable.asthma)
            Column() {
                Text(
                    text = stringResource(id = R.string.asthma),
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = asthmas[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].name,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = asthmas[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].strength,
                        style = MaterialTheme.typography.titleSmall
                    )

                }

            }

        }

    }

}

@Composable
fun DoseShowImage(problem: Int) {
    Image(
        painter = painterResource(id = problem), contentDescription = "TV Show Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(4.dp)
            .height(140.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
    )
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
                .height(110.dp)
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
                        tint = Color.Unspecified, modifier = Modifier.padding(0.dp),
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
            color = LoginGray,
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