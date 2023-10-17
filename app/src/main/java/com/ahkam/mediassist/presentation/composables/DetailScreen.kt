package com.ahkam.mediassist.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahkam.mediassist.MainActivity
import com.ahkam.mediassist.R


@Preview
@Composable
fun DetailScreen() {

    val activity = LocalContext.current as MainActivity

    Box(modifier = Modifier.fillMaxSize()) {

        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp, 50.dp, 10.dp, 10.dp)
                .shadow(10.dp, shape = RoundedCornerShape(corner = CornerSize(10.dp)))
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                if (activity.selectedItem) {
                    Image(
                        painter = painterResource(id = R.drawable.diabetes),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp)
                            .clip(shape = RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(id = R.string.diabetes),
                        style = MaterialTheme.typography.headlineLarge
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.asthma),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp)
                            .clip(shape = RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(id = R.string.asthma),
                        style = MaterialTheme.typography.headlineLarge
                    )
                }



                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Drug Name : ${
                        if (activity.selectedItem) {
                            activity.selectedD[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].name
                        } else {
                            activity.selectedA[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].name
                        }
                    }",
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Drug Strength : ${
                        if (activity.selectedItem) {
                            activity.selectedD[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].strength
                        } else {
                            activity.selectedA[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].strength
                        }
                    }",
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text =
                    if (activity.selectedItem) {
                        activity.selectedD[0].labs[0].missing_field
                    } else {
                        activity.selectedA[0].labs[0].missing_field
                    },
                    style = MaterialTheme.typography.bodyMedium
                )

            }
        }
    }

}