package com.ahkam.mediassist.presentation.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ahkam.mediassist.R
import com.ahkam.mediassist.ui.theme.Dark
import com.ahkam.mediassist.ui.theme.popinsFamily

@Preview
@Composable
fun LoginScreen() {
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
            .fillMaxHeight(0.2f),
        color = Dark,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false,
            ),
        )
    )

}