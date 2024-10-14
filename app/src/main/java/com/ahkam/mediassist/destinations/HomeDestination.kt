package com.ahkam.mediassist.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.ahkam.mediassist.navigation.NavigatorDestination

object HomeDestination  : NavigatorDestination {

    const val HOME_OBJECT = "homeObject"
    private const val HOME_ROUTE = "homeRoute"
    private const val HOME_OBJECT_ROUTE = "$HOME_ROUTE/{$HOME_OBJECT}"

    override fun route(): String = HOME_OBJECT_ROUTE

    override val arguments: List<NamedNavArgument>
        get() = listOf(navArgument(HOME_OBJECT) { type = NavType.StringType })

    fun createHomeRoute(homeObject: String) = "$HOME_ROUTE/$homeObject"
}