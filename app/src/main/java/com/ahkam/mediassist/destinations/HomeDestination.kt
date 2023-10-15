package com.ahkam.mediassist.destinations

import com.ahkam.mediassist.navigation.NavigatorDestination

object HomeDestination  : NavigatorDestination {
    private const val HOME_ROUTE = "homeRoute"
    override fun route(): String = HOME_ROUTE
}