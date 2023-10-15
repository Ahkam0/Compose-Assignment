package com.ahkam.mediassist.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class NavigatorImpl @Inject constructor() : Navigator {

    private val navigatorEvents = Channel<NavigatorEvent>()
    override val destinations: Flow<NavigatorEvent>
        get() = navigatorEvents.receiveAsFlow()

    override fun navigateUp(): Boolean =
        navigatorEvents.trySend(NavigatorEvent.NavigateUp).isSuccess

    override fun popBackStack() {
        navigatorEvents.trySend(NavigatorEvent.PopBackStack)
    }

    override fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit): Boolean =
        navigatorEvents.trySend(NavigatorEvent.Directions(route, builder)).isSuccess
}