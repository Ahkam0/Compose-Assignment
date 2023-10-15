package com.ahkam.mediassist.navigation

import androidx.navigation.NamedNavArgument

fun interface NavigatorDestination {

    fun route(): String
    val arguments: List<NamedNavArgument>
        get() = emptyList()
}