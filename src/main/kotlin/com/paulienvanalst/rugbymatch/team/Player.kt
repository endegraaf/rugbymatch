package com.paulienvanalst.rugbymatch.team

import java.util.*


data class Player(val position: Position, val backNumber: Int) {

    val isStarting: Boolean
        get() = backNumber in 1..15

}

