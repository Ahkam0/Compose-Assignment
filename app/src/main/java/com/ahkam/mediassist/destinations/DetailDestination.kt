package com.ahkam.mediassist.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.ahkam.mediassist.navigation.NavigatorDestination

object DetailDestination : NavigatorDestination {

    const val DETAIL_OBJECT = "detailObject"
    private const val DETAIL_ROUTE = "detailRoute"
    private const val DETAIL_OBJECT_ROUTE = "$DETAIL_ROUTE/{$DETAIL_OBJECT}"
    override fun route(): String = DETAIL_OBJECT_ROUTE

    override val arguments: List<NamedNavArgument>
        get() = listOf(navArgument(DETAIL_OBJECT) { type = NavType.StringType })

    fun createObjectRoute(detailObject: String) = "$DETAIL_ROUTE/$detailObject"
}