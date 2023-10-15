package com.ahkam.mediassist.destinations

import com.ahkam.mediassist.navigation.NavigatorDestination

object DetailDestination : NavigatorDestination {
    private const val DETAIL_ROUTE = "detailRoute"
    override fun route(): String = DETAIL_ROUTE
}