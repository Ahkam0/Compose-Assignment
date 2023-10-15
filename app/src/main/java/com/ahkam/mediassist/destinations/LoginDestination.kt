package com.ahkam.mediassist.destinations

import com.ahkam.mediassist.navigation.NavigatorDestination

object LoginDestination  : NavigatorDestination {
    private const val LOGIN_ROUTE = "loginRoute"
    override fun route(): String = LOGIN_ROUTE
}