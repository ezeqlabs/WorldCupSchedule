package br.com.ezeqlabs.worldcupschedule.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class WorldCupInfo : Serializable {
    lateinit var groups: List<Group>
    @SerializedName("knockout_phase")
    lateinit var knockoutPhase: List<Group>
    @SerializedName("games_today")
    lateinit var gamesToday: List<Group>
    lateinit var phase: String
    lateinit var winners: List<Team>
}