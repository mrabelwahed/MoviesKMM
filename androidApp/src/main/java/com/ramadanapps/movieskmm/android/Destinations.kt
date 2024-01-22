package com.ramadanapps.movieskmm.android


interface Destination {
    val title: String
    val route: String
    val routeWithArgs: String
}


object Home: Destination {
    override val title: String
        get() = "Movies"
    override val route: String
        get() = "home"
    override val routeWithArgs: String
        get() = route
}

val destinations = listOf(Home)