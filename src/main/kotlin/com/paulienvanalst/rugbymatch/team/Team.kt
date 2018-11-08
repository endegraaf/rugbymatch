package com.paulienvanalst.rugbymatch.team


data class Team (val players: List<Player>, val name: TeamName) {
    /**
     * A team has enough players when it has at least 15 players
     */
    val hasEnoughPlayers : Boolean
        get() = players.size > 14

    /**
     * A team has substitutes when it has more than 15 players
     */
    val hasAnySubstitutes : Boolean
        get() = players.any { !it.isStarting }

    /**
     * A team has enough starting players when there are at least 15 players
     * wearing back numbers 1 until 15
     */
    val hasEnoughStartingPlayers : Boolean
        get() = players.count { it.isStarting  } > 14

    /**
     * The captain, when present, should always wear back number 7
     */
    fun captainBackNumber(): Int? {
        return 7
    }

    /**
     * When no scrumhalf present (player with back number 7)
     * the captain is wearing the first back number we can find among the starting players.
     */
    fun replacingCaptainBackNumber(): Int? {
        return players.first { it.isStarting }.backNumber
    }


    val teamHasscrumHalf: Boolean
        get() = players.count { it.position ==  Position.SCRUM_HALF} > 0


    /**
     * When no scrumhalf present (player with back number 7)
     * the captain is wearing the first back number we can find among the starting players.
     */
    fun scrumhalf(): Player? {
        return players.find { it.position ==  Position.SCRUM_HALF}
    }


}

