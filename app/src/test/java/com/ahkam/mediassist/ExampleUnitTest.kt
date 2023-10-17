package com.ahkam.mediassist



import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.ahkam.mediassist.presentation.composables.LoginScreen
import com.ahkam.mediassist.presentation.composables.SplashScreen
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


class ExampleUnitTest {
    @Rule
    @JvmField
    var composeTestRule: ComposeContentTestRule = createComposeRule()


    @Test
    fun whenIClickOnButton_TheTextShouldChange() {
        composeTestRule.onNodeWithText("Hello").assertExists()
        composeTestRule.onNodeWithText("Hello").performClick()
        composeTestRule.onNodeWithText("Hello").assertDoesNotExist()
        composeTestRule.onNodeWithText("Bye").assertExists()
    }

}