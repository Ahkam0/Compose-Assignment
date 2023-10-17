package com.ahkam.mediassist.presentation.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ahkam.mediassist.MainActivity
import com.ahkam.mediassist.R
import com.ahkam.mediassist.destinations.HomeDestination
import com.ahkam.mediassist.destinations.LoginDestination
import com.ahkam.mediassist.presentation.viewmodel.ProblemViewModel
import com.ahkam.mediassist.ui.theme.Blue200
import com.ahkam.mediassist.ui.theme.Blue600
import com.ahkam.mediassist.ui.theme.Purple200
import com.ahkam.mediassist.ui.theme.popinsFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController
) {
    val activity = LocalContext.current as MainActivity

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(color = Color.White)
                .padding(0.dp, 0.dp, 0.dp, 5.dp),
            shape = RoundedCornerShape(0.dp, 0.dp, 40.dp, 40.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(id = R.drawable.login),
                contentDescription = "Login Image",
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
                .padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            var userValue by remember {
                mutableStateOf("")
            }

            var passValue by remember {
                mutableStateOf("")
            }

            Text(
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = popinsFamily,
                overflow = TextOverflow.Ellipsis,
                text = stringResource(id = R.string.login),
                textAlign = TextAlign.Start,
                maxLines = 1,
                modifier = Modifier
                    .align(alignment = Alignment.Start),
                color = Blue200,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    ),
                )
            )

            OutlinedTextField(
                value = userValue,
                onValueChange = { newText ->
                    userValue = newText
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.username),
                        fontWeight = FontWeight.Normal,
                        fontFamily = popinsFamily,
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Purple200,
                    unfocusedBorderColor = Blue200
                ),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_your_username),
                        fontWeight = FontWeight.Normal,
                        fontFamily = popinsFamily,
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = passValue,
                onValueChange = { newText ->
                    passValue = newText
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.password),
                        fontWeight = FontWeight.Normal,
                        fontFamily = popinsFamily,
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Purple200,
                    unfocusedBorderColor = Blue200
                ),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_your_password),
                        fontWeight = FontWeight.Normal,
                        fontFamily = popinsFamily,
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    activity.myUserName = userValue
                    navController.navigate(HomeDestination.route() ) {
                        popUpTo(LoginDestination.route()) {
                            inclusive = true
                        }
                    }

                },
                modifier = Modifier
                    .padding(0.dp, 20.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
                    .heightIn(50.dp),
                colors = ButtonDefaults.textButtonColors(
                    Blue600,
                    contentColor = Blue600
                )
            ) {
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = popinsFamily,
                    overflow = TextOverflow.Ellipsis,
                    text = stringResource(id = R.string.sign_in),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    color = Color.White,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false,
                        ),
                    )
                )
            }

        }

    }

}