package com.ahkam.mediassist.destinations

import com.ahkam.mediassist.navigation.NavigatorDestination

object SplashDestination : NavigatorDestination {
    private const val SPLASH_ROUTE = "splashRoute"
    override fun route(): String = SPLASH_ROUTE
}